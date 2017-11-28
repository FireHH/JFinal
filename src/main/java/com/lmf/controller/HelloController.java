package com.lmf.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.lmf.po.User;

public class HelloController extends Controller{

	//访问路径：http://localhost:8080/JfinalDemo/login。Confihg中配置无效
//	@ActionKey("/hello")
	public void index(){
		renderText("hello JFinal World");
		/*String msg="Welcome to JFinal World!";
		setAttr("hello", msg);
		//渲染跳转的界面
		renderFreeMarker("index.jsp");*/
	}
	
	
	public  void login(){
		//获取请求中问号挂参数
		String username = getPara("username");
		System.out.println("登录用户"+username);
		setAttr("msg", "登录成功!");
		//加上斜杠表示绝对路径，config里面设置的被忽略
		renderJsp("/index.jsp");
		
	}
	
	/**
	 * getModel--表单中的user.username与数据库字段对应
	 */
	public  void login2(){
		//获取请求中问号挂参数
		User user = getModel(User.class);
		
		// 如果表单域的名称为 "otherName.title"可加上一个参数来获取
		// user = getModel(User.class, "otherName");
		//如果希望用 传参时避免使用 modelName  前缀，可以 使用空串作为modelName 
		// 来实现： ：getModel(Blog.class, “”);
		System.out.println("登录用户"+user);
		setAttr("msg", "登录成功!");
		//加上斜杠表示绝对路径，config里面设置的被忽略
		renderJsp("/index.jsp");
		
	}
	
	public  void login3(){
		
		//获取请求中问号挂参数
		User user = getBean(User.class);
		
		// 如果表单域的名称为 "otherName.title"可加上一个参数来获取s
		// user = getBean(User.class, "otherName");
		//如果希望用 传参时避免使用 modelName  前缀，可以 使用空串作为modelName 
		// 来实现： ：getBean(User.class, "");
		System.out.println("登录用户"+user.getUsername());
		setAttr("msg", "登录成功!");
		//加上斜杠表示绝对路径，config里面设置的被忽略
		renderJsp("/index.jsp");
		
	}
	
	
	
}
