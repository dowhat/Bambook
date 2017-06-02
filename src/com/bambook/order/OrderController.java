package com.bambook.order;


import java.util.List;

import com.bambook.model.Orders;
import com.bambook.model.Userinfo;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class OrderController extends Controller {
	
	public void index(){
		if(getSessionAttr("userinfo") != null){
			setAttr("userinfo", getSessionAttr("userinfo"));
			Userinfo user = getSessionAttr("userinfo");
			String username = user.getUsername();
			List<Record> orderID = Db.find("select *, count(distinct orderID) from orders where userName = ? group by orderID", username);
			List<Record> order = Db.find
					("select o.orderID as id, o.bookID as bookID, o.orderStatus as status, "
							+ "o.orderNumber as number, o.orderDate as date, "
							+ "b.book as book, b.picture as picture, b.price as price "
							+ "from bookinfo as b, orders as o where o.bookID = b.bookID and o.userName = ?", username);
			setAttr("orderNumber", orderID.size());
			setAttr("order",order);
			setAttr("orderID", orderID);
			render("order.html");			
		}
		else{
			setAttr("msg", "请先登录");
			render("login.html");
		}
	}
	
	/* add new order */
	public void add(){
		
		if(getSessionAttr("userinfo") != null){
			setAttr("userinfo", getSessionAttr("userinfo"));	
			int bookID = getParaToInt(0);
			int num = getParaToInt("number", 1);
			java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
			Userinfo user = getSessionAttr("userinfo");
			Orders order = getModel(Orders.class);
			order.setBookID(bookID);
			order.setOrderNumber(num);
			order.setUserName(user.getUsername());
			order.setOrderDate(currentDate); 
			order.setOrderStatus("待付款");
			order.setOrderID((int)System.currentTimeMillis());
			order.save();
			redirect("/order");
		}
		else{
			setAttr("msg", "请先登录");
			render("login.html");
		}
	}
	
	//delete order by id
	public void delete(){
		int orderID = getParaToInt();
		Orders.dao.deleteById(orderID);
	}
//
//	public void addFromCart(){
//		int orderID = (int)System.currentTimeMillis();
//		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
//		List<Shoppingcart> cart = Shoppingcart.dao.find("select * from shoppingCart where username = ?",getSessionAttr("userinfo"));
//		for(){
//			Orders order = getModel(Orders.class);
//			order.setBookID(bookID);
//			order.setOrderNumber(num);
//			order.setUserName(user.getUsername());
//			order.setOrderDate(currentDate); 
//			order.setOrderStatus(0);
//			order.setOrderID((int)System.currentTimeMillis());
//			order.save();
//		}
//	}
}
