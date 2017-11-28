package com.lmf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class FileController extends Controller{
	
	public void uploadFile(){
		//实际保存路径D:\\apache-tomcat-9.0.1\\webapps\\JfinalDemo2\\upload\\upload
		UploadFile file = getFile("file", "/upload", 3*5*1024*1024);
		
	
		System.out.println(file);
		renderJsp("index.jsp");
	}
	
	public void downLoad(){
		String path = getSession().getServletContext().getRealPath("upload/");
		File file = new File(path + getPara("filename"));
		System.out.println(path);
		if (file.exists()) {
			renderFile(file);
			} else {
			renderJson("文件不存在");
			}
	}

}
