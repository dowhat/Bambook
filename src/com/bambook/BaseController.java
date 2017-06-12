package com.bambook;

import com.bambook.model.Maincatalog;
import com.bambook.model.Subcatalog;
import com.jfinal.core.Controller;

public class BaseController extends Controller {

	public void index() {
		// TODO Auto-generated method stub
		setAttr("mainCatalog", Maincatalog.dao.find("select * from Maincatalog"));
		setAttr("subCatalog", Subcatalog.dao.find("select * from subcatalog"));
		setAttr("userinfo", getSessionAttr("userinfo"));
	}
}
