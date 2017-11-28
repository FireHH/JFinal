package com.lmf.controller;

import com.jfinal.core.Controller;

public class StudentController extends Controller{

	
	public void getStu(){
		
		renderJsp("list.jsp");
	}
	public void addStu(){
		
		renderJsp("add.jsp");
	}
	public void delStu(){
		
		renderJsp("del.jsp");
	}
	public void updStu(){
		
		renderJsp("upd.jsp");
	}
}
