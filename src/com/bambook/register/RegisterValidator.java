package com.bambook.register;

import com.bambook.model.Userinfo;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class RegisterValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("Userinfo.userName", "username", "请输入用户名");
		validateRequiredString("Userinfo.password", "password", "请输入密码");
//		validateRequiredString("userinfo.username", "password2", "请再次输入密码");
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.keepModel(Userinfo.class);
		
//		String actionKey = getActionKey();
//		if(actionKey.equals("/register/add"))
//			c.redirect("/login");
//		else if(actionKey.equals("/userCenter/update"))
//			c.render("userCenter.html");
	}

}
