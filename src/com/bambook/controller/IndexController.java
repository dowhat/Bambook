package com.bambook.controller;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		render index page
*/
public class IndexController extends BaseController {
	public void index() {
		super.index();
		render("index.html");
	}

}
