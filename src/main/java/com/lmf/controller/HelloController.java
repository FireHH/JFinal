package com.lmf.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.lmf.po.User;

public class HelloController extends Controller{

	//����·����http://localhost:8080/JfinalDemo/login��Confihg��������Ч
//	@ActionKey("/hello")
	public void index(){
		renderText("hello JFinal World");
		/*String msg="Welcome to JFinal World!";
		setAttr("hello", msg);
		//��Ⱦ��ת�Ľ���
		renderFreeMarker("index.jsp");*/
	}
	
	
	public  void login(){
		//��ȡ�������ʺŹҲ���
		String username = getPara("username");
		System.out.println("��¼�û�"+username);
		setAttr("msg", "��¼�ɹ�!");
		//����б�ܱ�ʾ����·����config�������õı�����
		renderJsp("/index.jsp");
		
	}
	
	/**
	 * getModel--���е�user.username�����ݿ��ֶζ�Ӧ
	 */
	public  void login2(){
		//��ȡ�������ʺŹҲ���
		User user = getModel(User.class);
		
		// ������������Ϊ "otherName.title"�ɼ���һ����������ȡ
		// user = getModel(User.class, "otherName");
		//���ϣ���� ����ʱ����ʹ�� modelName  ǰ׺������ ʹ�ÿմ���ΪmodelName 
		// ��ʵ�֣� ��getModel(Blog.class, ����);
		System.out.println("��¼�û�"+user);
		setAttr("msg", "��¼�ɹ�!");
		//����б�ܱ�ʾ����·����config�������õı�����
		renderJsp("/index.jsp");
		
	}
	
	public  void login3(){
		
		//��ȡ�������ʺŹҲ���
		User user = getBean(User.class);
		
		// ������������Ϊ "otherName.title"�ɼ���һ����������ȡs
		// user = getBean(User.class, "otherName");
		//���ϣ���� ����ʱ����ʹ�� modelName  ǰ׺������ ʹ�ÿմ���ΪmodelName 
		// ��ʵ�֣� ��getBean(User.class, "");
		System.out.println("��¼�û�"+user.getUsername());
		setAttr("msg", "��¼�ɹ�!");
		//����б�ܱ�ʾ����·����config�������õı�����
		renderJsp("/index.jsp");
		
	}
	
	
	
}
