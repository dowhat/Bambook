package com.bambook.userCenter;

import com.bambook.model.Address;
import com.bambook.model.Userinfo;
import com.jfinal.core.Controller;

public class UserCenterController extends Controller {
	
	public void index(){
		if(getSessionAttr("userinfo") != null){
			Userinfo user = getSessionAttr("userinfo");
			setAttr("userinfo", getSessionAttr("userinfo"));
			setAttr("address", Address.dao.find
					("select * from address where username = ?", user.getUsername()));
			render("userCenter.html");			
		}
		else{
			setAttr("msg", "请先登录");
			render("login.html");
		}
	}
	
	//add new address
	public void addAddress(){
		
	}
	//edit address
	public void editAddress(){
		
	}
	//edit user info
	public void editUserinfo(){
		
	}
}
