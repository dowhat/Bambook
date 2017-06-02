package com.bambook.manageCenter;

import com.jfinal.core.Controller;

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
	
	//add new book into database
	public void addBook(){
		
	}
	
	//edit book info
	public void editBook(){
		
	}
}
