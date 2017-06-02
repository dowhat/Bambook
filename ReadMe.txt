基于bootstrap + JFinal的在线购书网站 简书网

1、界面：通过bootstrap基本实现了chrom IE的适配，但是手机或者小屏幕浏览未实现
2、搜索：通过SQL模糊搜索实现
3、信息管理：个人中心和管理员中心未完善

文件结构
res
->databaseConfig.txt				数据库配置
->demo.sql							数据库文件
->log4j.properties					系统log配置

src
--com
  --bambook
    --bookinfo
	  ->BookInfoController.java		书籍详情action	
    --excel
    --index
	  ->IndexController.java		主页action
    --login
	  ->LoginController.java		登录页action
	  ->LoginInterceptor.java		登录页拦截器
	  ->LoginValidator.java			登录页拦截器
	  ->VerifyPicture.java			~~~~验证码生成函数
    --manageCenter
	  ->manageCenterController.java	管理员页action
    --model
	  ->_JFinalGenerator.java		~~~~数据库表单映射文件生成器
	  ->_MappingKit.java
	  ->[table_name].java			生成的数据库表单类
	  --base
	    ->Base[table_name].java		生成的数据库表单类接口
	--order
	  ->OrderController.java		订单页action
	--register
	  ->RegisterCOntroller.java		注册页action
	  ->RegisterValidator.java		注册页拦截器
	--search
	  ->SearchController.java		搜索结果action
	--shoppingCart
	  ->ShoppingCartController.java	购物车action
	--user
	  ->CatalogController.java		无效类
	  ->UserController.java			无效类
	--userCenter
	  ->UserCenterController.java	用户中心action
	->BambookConfig.java			~~~~JFinal配置类
	
	WebRoot
	--css							层叠样式表
	--fonts							字体图标
	--js							脚本
	--picture						图片
	--WEB-INF
	->_paginate.html				分页共享模板
	->bookInfo.html					图书详细信息页面
	->help.html						帮助页面（未完成）
	->index.html					主页
	->introducation.html			推荐页（未完成）
	->login.html					登录页
	->managerCenter.html			管理员页（未完成）
	->order.html					订单管理
	->register.html					注册页面
	->searchResult.html				搜索结果页
	->userCenter.html				用户中心页