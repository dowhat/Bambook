package com.bambook.index;

import java.util.List;

import com.bambook.BaseController;

import redis.clients.jedis.Jedis;

public class IndexController extends BaseController {
	public void index() {
		super.index();
		render("index.html");
	}

}
