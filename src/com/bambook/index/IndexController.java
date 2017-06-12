package com.bambook.index;

import com.bambook.BaseController;

public class IndexController extends BaseController {
	public void index() {
		super.index();
		render("index.html");
	}

}
