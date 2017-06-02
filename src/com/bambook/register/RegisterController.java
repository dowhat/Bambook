package com.bambook.register;

import java.io.IOException;

import com.bambook.login.VerifyPicture;
import com.bambook.model.Userinfo;
import com.jfinal.core.Controller;

public class RegisterController extends Controller {
	public void index() throws IOException{
		String temp = VerifyPicture.drawPicture();
		setSessionAttr("verifyCode2", temp);
		System.out.println("verify code is: " + temp);
		render("register.html");
	}

	public void add(){
		String verifyCode = getPara("vcode");
		String password2 = getPara("password2");
		String username = getPara("userinfo.username");
		if(Userinfo.dao.findFirst("select * from userinfo where username = ?", username)!= null){
			System.out.println("error7: the username is already exist");
			setAttr("msg2", "用户名已存在");
			render("register.html");
			return;
			
		}
		if (verifyCode.equals("")){
			System.out.println("error4: verify code is null");
			setAttr("msg2", "验证码不得为空");
			render("register.html");
			return;			
		}
		else if(!verifyCode.equals(getSessionAttr("verifyCode2"))){
			System.out.println("error5: verify code is wrong");
			setAttr("msg2", "验证码错误");
			render("register.html");
			return;
		}
		if (!password2.equals(getPara("userinfo.password"))){
			System.out.println("error6: two password is different");
			setAttr("msg2", "两次输入的密码不同");
			render("register.html");
			return;	
		}
		Userinfo user = getModel(Userinfo.class);
		user.setRole("user");
		user.save();
		redirect("/login");
	}
}
