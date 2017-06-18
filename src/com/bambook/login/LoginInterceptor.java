package com.bambook.login;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		login interceptor
*/
public class LoginInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		System.out.println("Before invoking " + inv.getActionKey());
		inv.invoke();
		System.out.println("After invoking " + inv.getActionKey());
	}
}
