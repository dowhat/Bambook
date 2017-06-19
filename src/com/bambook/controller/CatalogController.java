package com.bambook.controller;

import java.util.List;

import com.bambook.model.Maincatalog;
import com.bambook.model.Subcatalog;
import com.jfinal.core.Controller;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		a useless class
*/
public class CatalogController extends Controller {
	public List<Maincatalog> findMCatalog(){
		List<Maincatalog> mCatalog = getModel(Maincatalog.class)
				.find("select * from mainCatalog");
		return mCatalog;
	}
	
	public List<Subcatalog> fingSCatalog(int id){
		List<Subcatalog> sCatalog = getModel(Subcatalog.class)
				.find("select * from subCatalog where mCatalogID = ?", id);
		return sCatalog;
	}
	
	//add new mainCatalog
	public void addMainCatalog(){
		
	}
	
	//add new subCatalog
	public void addSubCatalog(){
		
	}
}
