package com.bambook;

import com.bambook.bookInfo.BookInfoController;
import com.bambook.index.IndexController;
import com.bambook.login.LoginController;
import com.bambook.manageCenter.manageCenterController;
import com.bambook.model._MappingKit;
import com.bambook.order.OrderController;
import com.bambook.register.RegisterController;
import com.bambook.search.SearchController;
import com.bambook.shoppingCart.ShoppingCartController;
import com.bambook.userCenter.UserCenterController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		config
*/
public class BambookConfig extends JFinalConfig {

	public static void main(String[] args) {
		/**
		 * 特别注意：Eclipse 之下建议的启动方式
		 */
		JFinal.start("WebRoot", 80, "/", 5);

		/**
		 * 特别注意：IDEA 之下建议的启动方式，仅比 eclipse 之下少了最后一个参数
		 */
		// JFinal.start("WebRoot", 80, "/");
	}

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("databaseConfig.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/login", LoginController.class,"/");
		me.add("/register", RegisterController.class,"/");
		me.add("/", IndexController.class, "/");
		me.add("/userCenter", UserCenterController.class, "/");
		me.add("/shoppingCart", ShoppingCartController.class, "/");
		me.add("/order", OrderController.class, "/");
		me.add("/search", SearchController.class, "/");
		me.add("/bookinfo", BookInfoController.class, "/");
		me.add("/manageCenter", manageCenterController.class, "/");
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		me.addSharedFunction("/_paginate.html");
	}

	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}

	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);

		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		// 所有映射在 MappingKit 中自动化搞定
		_MappingKit.mapping(arp);
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

}
