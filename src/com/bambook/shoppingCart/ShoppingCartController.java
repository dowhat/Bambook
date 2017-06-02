package com.bambook.shoppingCart;

import java.util.List;

import com.bambook.model.Shoppingcart;
import com.bambook.model.Userinfo;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class ShoppingCartController extends Controller {
	
	public void index(){
		if(getSessionAttr("userinfo") != null){
			setAttr("userinfo", getSessionAttr("userinfo"));
//			Model m = m.dao().find("")
			Userinfo user = getSessionAttr("userinfo");
			String username = user.getUsername();
			List<Record> cart = Db.find("select s.cartID as id,s.bookID as bookID,s.number as number,"
					+ "b.price as price,b.book as book,b.picture as picture "
					+ "from bookinfo as b, shoppingCart as s where s.bookID = b.bookID and s.userName = ?"
					, username);
			setAttr("cartNumber", cart.size());
			setAttr("cart",cart);
			render("shoppingCart.html");			
		}
		else{
			setAttr("msg", "请先登录");
			render("login.html");
		}
	}
	//add book to shopping cart
	public void add(){
		if(getSessionAttr("userinfo") != null){
			setAttr("userinfo", getSessionAttr("userinfo"));
			Shoppingcart cart = getModel(Shoppingcart.class);
			Userinfo user = getSessionAttr("userinfo");
			cart.setUserName(user.getUsername());
			cart.setBookID(getParaToInt(0));
			cart.setNumber(getParaToInt("number", 1));
			cart.save();
			redirect("/shoppingCart");			
		}
		else{
			setAttr("msg", "请先登录");
			render("login.html");
		}
	}
	//delete book from shopping cart
	public void delete(){
		Shoppingcart.dao.deleteById(getParaToInt());
		index();
	}
	//delete all book from shopping cart
	public void deleteAll(){
		Shoppingcart.dao.delete();
	}
	//pay for the book 
	public void pay(){
		
	}
}
