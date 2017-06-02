package com.bambook.user;

import com.bambook.model.Userinfo;
import com.jfinal.core.Controller;

public class UserController extends Controller {
	//update userinfo 
	public void update(){
		getModel(Userinfo.class).save();		
	}
	//add new user into userinfo table
	public void add(){
		getModel(Userinfo.class).save();
	}
	//delete user
	public void delete(){
		Userinfo.dao.deleteById(getParaToInt());
	}
	//show userinfo
	public void find(){
		
	}
}
