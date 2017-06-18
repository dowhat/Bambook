package com.bambook.login;

import java.io.IOException;

//import java.util.List;

import com.bambook.model.Userinfo;
import com.jfinal.core.Controller;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		login controller ,check login data
*/
public class LoginController extends Controller {
	public void index() throws IOException {
		String temp = VerifyPicture.drawPicture();
		setSessionAttr("verifyCode", temp);
		System.out.println("verify code is: " + temp);
		render("/login.html");
	}

	// login verify
	public void login() {
		String username = getPara("username");
		String password = getPara("password");
		String verifyCode = getPara("verifyCode");
		if (verifyCode.equals("")){
			System.out.println("error2: verify code is null");
			setAttr("msg", "验证码不得为空");
			render("login.html");
			return;			
		}
		else if(!verifyCode.equals(getSessionAttr("verifyCode"))){
			System.out.println("error3: verify code is wrong");
			setAttr("msg", "验证码错误");
			render("login.html");
			return;
		}
		Userinfo user = getModel(Userinfo.class)
				.findFirst("select * from userinfo where username = ?  and password = ?", username, password);
		if (user != null && user.getRole().equals("user")) {
			setSessionAttr("userinfo", user);
			redirect("/");
		} 
		else if(user != null && user.getRole().equals("admin")){
			setSessionAttr("userinfo", user);
			redirect("/manageCenter");
		}
		else{
			System.out.println("error1" + password + username);
			setAttr("msg", "用户名或密码错误");
			render("login.html");
//			redirect("/login");
			return;
		}
	}
	
	public void logout(){
		removeSessionAttr("userinfo");
		redirect("/");
	}

}
