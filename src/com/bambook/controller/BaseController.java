package com.bambook.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bambook.model.Maincatalog;
import com.bambook.model.Subcatalog;
import com.jfinal.core.Controller;

import redis.clients.jedis.Jedis;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		base controller class ,define jedis client and userinfo
*/

public class BaseController extends Controller {

	Jedis jedis = new Jedis("localhost");
	
	public void index() {
		// TODO Auto-generated method stub
		List<Maincatalog> mC = Maincatalog.dao.find("select * from Maincatalog");
//		Gson gson = new Gson();
//		String json = gson.toJson(mC);
//		List<Maincatalog> mmC = gson.fromJson(json, TypeToken<List<Maincatalog>>(){}.getType());
//		System.out.println(json);
//		System.out.println(gson.toJson(mmC));
		setAttr("mainCatalog", mC);
		setAttr("subCatalog", Subcatalog.dao.find("select * from subcatalog"));
		setAttr("userinfo", getSessionAttr("userinfo"));
		List<String> hotSearch = jedis.lrange("hotSearch", 0, 3);
		setAttr("hotSearch", hotSearch);
		HttpSession session = getSession();
		session.getId();
	}
}
