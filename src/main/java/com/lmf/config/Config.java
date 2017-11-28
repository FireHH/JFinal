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
	 * ����JFinal�ĳ���ֵ
	 */
	@Override
	public void configConstant(Constants me) {
		
//		me.setDevMode(getPropertyToBoolean("devMode",true));
//		me.setViewType(ViewType.FREE_MARKER);
		
		
		// ��һ��ʹ��use���ص����ý���Ϊ�����ã�����ͨ��PropKit.get(...)ֱ��ȡֵ
		PropKit.use("a_little_config.txt");
		me.setDevMode(PropKit.getBoolean("devMode"));
		
		
		
	}

	/**
	 * ����JFinal�ķ���·�ɣ�controllerKey��λ��controller
	 */
	@Override
	public void configRoute(Routes me) {
		//Ϊ���е�Controller������ͼ��Ⱦʱ��Ļ���·��
		me.setBaseViewPath("/");
		me.add("/hello",HelloController.class);//viewPath
		me.add("/stu",StudentController.class,"/stu");
		me.add("/file",FileController.class,"");
		//���·��ΪBasePath+viewPath+view(Controller�е�render��view��)
		
		//ע�⣺view��"/"��ͷʱ��ʾ����·����BasePath��viewPath��������
		
	}

	/**
	 * ����template engine
	 */
	@Override
	public void configEngine(Engine arg0) {
		
	}

	@Override
	public void configPlugin(Plugins me) {
		//�������ݿ�������Ϣ
		/*loadPropertyFile("a_little_config.txt");
		 * 
		//druid����Դ���
		DruidPlugin dp=new DruidPlugin(getProperty("url"), getProperty("username"), getProperty("password"), getProperty("driverClassName"));
		me.add(dp);
		//ActiveRecord֧�ֲ��
		ActiveRecordPlugin arp=new ActiveRecordPlugin(dp);
		me.add(arp);
		//���ݿ����ʵ���Ӧ��idĬ��Ϊid
		arp.addMapping("user",User.class);
		//���id���Ʋ�Ϊid������Ҫ����ָ��
		arp.addMapping(��user��, ��user_id��, User.class)
		*
		*/
		
		
		/*// �ǵ�һ��ʹ��use���ص����ã���Ҫͨ��ÿ��ʹ��use��ָ�������ļ�������ȡֵ
		String redisHost = PropKit.use("redis_config.txt").get("host");
		int redisPort = PropKit.use("redis_config.txt").getInt("port");
		RedisPlugin rp = new RedisPlugin("myRedis", redisHost, redisPort);
		me.add(rp);
		
		
		// �ǵ�һ��ʹ�� use���ص����ã�Ҳ�����ȵõ�һ��Prop������ͨ���ö�������ȡֵ
		Prop p = PropKit.use("db_config.txt");
		DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"), p.get("user")��);
		me.add(dp);*/
		
		//PropKit.use(��)�����ڼ��������ļ������Ժ�Ὣ���ݻ������ڴ�֮��         
		//useless�������
//		PropKit.useless("a_little_config.txt");
		
		
	}

	/*
	 * (non-Javadoc)
	 * ����������Ϊ�������ȣ���Globel��
	 * ȫ�ֽ����ض���action���󣬳���ʹ��@clear��controller�����
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		/*TxByRegex ��������ͨ������������ʽ�� action �������أ��� actionKey ����
		��ƥ���Ͻ���������
		TxByActionKeys ���Զ�ָ���� actionKey �������ز���������
		TxByMethods ���Զ�ָ���� method �������ز���������*/
		me.add(new TxByMethodRegex("(.*save.*|.*update.*)"));
		me.add(new TxByMethods("save", "update"));
		me.add(new TxByActionKeyRegex("/trans.*"));
		me.add(new TxByActionKeys("/tx/save", "/tx/update"));
		
	}

	/**
	 * �˷�����������JFinal��Handler�����´�����������ΪResourceHandler�Ĵ�������
	 * Handler,���Խӹ����� web ���󣬲���Ӧ��ӵ����ȫ�Ŀ���Ȩ�����Ժܷ����ʵ�ָ��߲�Ĺ�������չ
	 */
	@Override
	public void configHandler(Handlers me) {
		//����������·��
		me.add(new ContextPathHandler("contextPath"));
		
	}
	
	/**
	 * ��ϵͳ������ɺ�ص�
	 */
	@Override
	public void afterJFinalStart() {
		// TODO Auto-generated method stub
		super.afterJFinalStart();
	}
	
	/**
	 * ��ϵͳ�ر�ǰ�ص�
	 */
	@Override
	public void beforeJFinalStop() {
		// TODO Auto-generated method stub
		super.beforeJFinalStop();
	}


}
