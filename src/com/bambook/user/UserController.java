package com.bambook.user;

import com.bambook.model.Userinfo;
import com.jfinal.core.Controller;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		a useless class
*/
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
