package com.bambook.bookInfo;

import com.bambook.model.Bookinfo;
import com.bambook.model.Bookreview;
import com.bambook.model.Maincatalog;
import com.bambook.model.Subcatalog;
import com.jfinal.core.Controller;

public class BookInfoController extends Controller {

	// render bookInfo.html 
	public void index(){
		int bookID = getParaToInt(0);
		Bookinfo book = Bookinfo.dao.findById(bookID);
		Subcatalog s = Subcatalog.dao.findById(book.getCatalogID());
		Maincatalog m = Maincatalog.dao.findById(s.getMCatalogID());
		setAttr("userinfo", getSessionAttr("userinfo"));
		setAttr("sCatalog", s);
		setAttr("mCatalog", m.getMCatalogName());
		setAttr("bookinfo", Bookinfo.dao.findById(bookID));
		setAttr("bookreview", Bookreview.dao.paginate(1, 9,"select *", " from bookreview where bookID = ? order by time", bookID));
		setAttr("number", Bookreview.dao.findFirst("select count(*) num from (select * from bookreview where bookID = ?) as number", bookID));
		render("bookInfo.html");
	}
}
