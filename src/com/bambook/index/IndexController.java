package com.bambook.index;

import com.bambook.model.Maincatalog;
import com.bambook.model.Subcatalog;
import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index() {
		setAttr("mainCatalog", Maincatalog.dao.find("select * from Maincatalog"));
		setAttr("subCatalog", Subcatalog.dao.find("select * from subcatalog"));
		setAttr("userinfo", getSessionAttr("userinfo"));
		render("index.html");
	}

}
