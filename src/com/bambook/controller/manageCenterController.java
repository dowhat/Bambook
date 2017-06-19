package com.bambook.controller;

import com.jfinal.core.Controller;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		render manager center page
*/
public class manageCenterController extends Controller {

	public void index(){
		setAttr("userinfo", getSessionAttr("userinfo"));
		render("managerCenter.html");
	}
	
	//update manager information
	public void update(){
		
	}
	
	//delete a user
	public void delete(){
		
	}
	
	//show book info
	public void showBook(){
	}
	//add new book into database
	public void addBook(){
		
	}
	
	//edit book info
	public void editBook(){
		
	}
}
