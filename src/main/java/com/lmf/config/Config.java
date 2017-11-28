package com.lmf.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.tx.TxByActionKeyRegex;
import com.jfinal.plugin.activerecord.tx.TxByActionKeys;
import com.jfinal.plugin.activerecord.tx.TxByMethodRegex;
import com.jfinal.plugin.activerecord.tx.TxByMethods;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.lmf.controller.FileController;
import com.lmf.controller.HelloController;
import com.lmf.controller.StudentController;
import com.lmf.po.User;

public class Config extends JFinalConfig{

	/**
	 * 配置JFinal的常量值
	 */
	@Override
	public void configConstant(Constants me) {
		
//		me.setDevMode(getPropertyToBoolean("devMode",true));
//		me.setViewType(ViewType.FREE_MARKER);
		
		
		// 第一次使用use加载的配置将成为主配置，可以通过PropKit.get(...)直接取值
		PropKit.use("a_little_config.txt");
		me.setDevMode(PropKit.getBoolean("devMode"));
		
		
		
	}

	/**
	 * 配置JFinal的访问路由，controllerKey定位到controller
	 */
	@Override
	public void configRoute(Routes me) {
		//为所有的Controller设置视图渲染时候的基础路径
		me.setBaseViewPath("/");
		me.add("/hello",HelloController.class);//viewPath
		me.add("/stu",StudentController.class,"/stu");
		me.add("/file",FileController.class,"");
		//最后路径为BasePath+viewPath+view(Controller中的render（view）)
		
		//注意：view以"/"开头时表示绝对路径，BasePath和viewPath将被忽略
		
	}

	/**
	 * 配置template engine
	 */
	@Override
	public void configEngine(Engine arg0) {
		
	}

	@Override
	public void configPlugin(Plugins me) {
		//加载数据库配置信息
		/*loadPropertyFile("a_little_config.txt");
		 * 
		//druid数据源插件
		DruidPlugin dp=new DruidPlugin(getProperty("url"), getProperty("username"), getProperty("password"), getProperty("driverClassName"));
		me.add(dp);
		//ActiveRecord支持插件
		ActiveRecordPlugin arp=new ActiveRecordPlugin(dp);
		me.add(arp);
		//数据库表与实体对应，id默认为id
		arp.addMapping("user",User.class);
		//如果id名称不为id，则需要单独指定
		arp.addMapping(“user”, “user_id”, User.class)
		*
		*/
		
		
		/*// 非第一次使用use加载的配置，需要通过每次使用use来指定配置文件名再来取值
		String redisHost = PropKit.use("redis_config.txt").get("host");
		int redisPort = PropKit.use("redis_config.txt").getInt("port");
		RedisPlugin rp = new RedisPlugin("myRedis", redisHost, redisPort);
		me.add(rp);
		
		
		// 非第一次使用 use加载的配置，也可以先得到一个Prop对象，再通过该对象来获取值
		Prop p = PropKit.use("db_config.txt");
		DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"), p.get("user")…);
		me.add(dp);*/
		
		//PropKit.use(…)方法在加载配置文件内容以后会将数据缓存在内存之中         
		//useless清除缓存
//		PropKit.useless("a_little_config.txt");
		
		
	}

	/*
	 * (non-Javadoc)
	 * 拦截器，分为四种粒度，（Globel）
	 * 全局将拦截多有action请求，除非使用@clear在controller中清除
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		/*TxByRegex 拦截器可通过传入正则表达式对 action 进行拦截，当 actionKey 被正
		则匹配上将开启事务。
		TxByActionKeys 可以对指定的 actionKey 进行拦截并开启事务，
		TxByMethods 可以对指定的 method 进行拦截并开启事务。*/
		me.add(new TxByMethodRegex("(.*save.*|.*update.*)"));
		me.add(new TxByMethods("save", "update"));
		me.add(new TxByActionKeyRegex("/trans.*"));
		me.add(new TxByActionKeys("/tx/save", "/tx/update"));
		
	}

	/**
	 * 此方法用来配置JFinal的Handler，如下代码配置了名为ResourceHandler的处理器，
	 * Handler,可以接管所有 web 请求，并对应用拥有完全的控制权，可以很方便地实现更高层的功能性扩展
	 */
	@Override
	public void configHandler(Handlers me) {
		//设置上下文路径
		me.add(new ContextPathHandler("contextPath"));
		
	}
	
	/**
	 * 在系统启动完成后回调
	 */
	@Override
	public void afterJFinalStart() {
		// TODO Auto-generated method stub
		super.afterJFinalStart();
	}
	
	/**
	 * 在系统关闭前回调
	 */
	@Override
	public void beforeJFinalStop() {
		// TODO Auto-generated method stub
		super.beforeJFinalStop();
	}


}
