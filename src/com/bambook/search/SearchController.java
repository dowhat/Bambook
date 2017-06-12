package com.bambook.search;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.bambook.SolrService;
import com.bambook.model.Bookinfo;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class SearchController extends Controller {
	
	//search by sub catalog 
	public void catalogSearch(){
		int catalogID = getParaToInt(0);
		int page = getParaToInt(1, 1);
		String orderSQL = orderSQL(getParaToInt(2, 0));
		System.out.println(orderSQL);
		setAttr("bookinfo", Bookinfo.dao.paginate
				(page, 5, "select *", "from bookinfo where catalogID = ?" + orderSQL, catalogID));
		setAttr("number", Bookinfo.dao.find
				("select * from bookinfo where catalogID = ?", catalogID).size());
		result("catalogSearch", catalogID);
	}
	
	//search by writer
	public void writerSearch() throws UnsupportedEncodingException{
		int page;
		String writer;
		writer = URLDecoder.decode(getPara(0),"UTF-8");
		System.out.println(writer);
		page = getParaToInt(1, 1);
		int order = getParaToInt(2, 0);
		String orderSQL = orderSQL(order);
		setAttr("bookinfo", Bookinfo.dao.paginate
				(page, 5, "select *", "from bookinfo where writer = ? " + orderSQL, writer));
		setAttr("number", Bookinfo.dao.find
				("select * from bookinfo where writer = ?", writer).size());
		result("writerSearch", writer);
	}
	
	//search by publish firm
	public void pubFirmSearch() throws UnsupportedEncodingException{
		int page;
		String pubFirm;
		pubFirm = URLDecoder.decode(getPara(0),"UTF-8");
		System.out.println(pubFirm);
		page = getParaToInt(1, 1);
		System.out.println(page);
		String orderSQL = orderSQL(getParaToInt(2, 0));
		setAttr("bookinfo", Bookinfo.dao.paginate
				(page, 5, "select *", "from bookinfo where pubFirm = ?" + orderSQL, pubFirm));
		setAttr("number", Bookinfo.dao.find
				("select * from bookinfo where pubFirm = ?", pubFirm).size());
		result("pubFirmSearch", pubFirm);
	}
	
	//search function
	public void search() throws UnsupportedEncodingException{
		String input = getPara("input");
		String field = "bookID";
		int page = getParaToInt(1, 1);
		int order = getParaToInt(2, 0);
		if(order == 4){
			field = "sales";
		} else if (order == 1){
			field = "price";
		}
		if((input=getPara("input"))==null){
			input=URLDecoder.decode(getPara(0),"UTF-8");
		}
		else if(input==""){
			System.out.println("hello");
			redirect("/");
			return;
		}
		SolrService search = new SolrService();
		SolrDocumentList docs = search.search(input, field);
		int size = docs.size();
		int totalPage = (int) (size / 5);
		if (docs.size() % 5 != 0) {
			totalPage++;
		}
		Page<SolrDocument> pages = new Page<SolrDocument>(getPageList(docs, page, 5), page, 5, totalPage, docs.size());
		setAttr("bookinfo", pages);
//		String orderSQL = orderSQL(getParaToInt(2, 0));
		if(input != null){
//			String input1 = "%" + input + "%";
//			String sql = "from bookinfo where pubFirm like ? or book like ? or abstracts like ? or writer like ?";
//			setAttr("bookinfo", Bookinfo.dao.paginate
//					(page, 5, "select *", sql + orderSQL, input1,input1,input1,input1));
//			setAttr("number", Bookinfo.dao.findFirst("select count(*) num from (select *" + sql +") as number", input1,input1,input1,input1));
			setAttr("number", size);
			result("search", input);
		}
		
	}
	
	public void result(String searchFunc, String searchTemp){
		setAttr("searchFunc", searchFunc);
		setAttr("searchTemp", searchTemp);
		setAttr("userinfo", getSessionAttr("userinfo"));		
		render("searchResult.html");
	}
	
	public void result(String searchFunc, int searchTemp){
		setAttr("searchFunc", searchFunc);
		setAttr("searchTemp", searchTemp);
		setAttr("userinfo", getSessionAttr("userinfo"));		
		render("searchResult.html");
	}
	public String orderSQL(int i){
		String orderSQL = "";
		switch(i){
		case 1: orderSQL = "order by price ASC";
		break;
		case 2: orderSQL = "order by price DESC";
		break;
		case 3: orderSQL = "order by sales ASC";
		break;
		case 4: orderSQL = "order by sales DESC";
		break;
		default:orderSQL="";
		}
		return orderSQL;
	}
	
	public List<SolrDocument> getPageList(List<SolrDocument> docs,int pageNum,int pageSize){
		int fromIndex, toIndex;
		int size = docs.size();
		fromIndex = pageSize * (pageNum - 1);
		if(size > pageSize * pageNum){
			toIndex = pageSize * pageNum;
		} else {
			toIndex = size;
		}
		return docs.subList(fromIndex, toIndex);
	}
}
