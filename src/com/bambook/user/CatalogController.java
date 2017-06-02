package com.bambook.user;

import java.util.List;

import com.bambook.model.Maincatalog;
import com.bambook.model.Subcatalog;
import com.jfinal.core.Controller;

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
	
	public void addSubCatalog(){
		
	}
}
