����bootstrap + JFinal�����߹�����վ ������

1�����棺ͨ��bootstrap����ʵ����chrom IE�����䣬�����ֻ�����С��Ļ���δʵ��
2��������ͨ��SQLģ������ʵ��
3����Ϣ�����������ĺ͹���Ա����δ����

�ļ��ṹ
res
->databaseConfig.txt				���ݿ�����
->demo.sql							���ݿ��ļ�
->log4j.properties					ϵͳlog����

src
--com
  --bambook
    --bookinfo
	  ->BookInfoController.java		�鼮����action	
    --excel
    --index
	  ->IndexController.java		��ҳaction
    --login
	  ->LoginController.java		��¼ҳaction
	  ->LoginInterceptor.java		��¼ҳ������
	  ->LoginValidator.java			��¼ҳ������
	  ->VerifyPicture.java			~~~~��֤�����ɺ���
    --manageCenter
	  ->manageCenterController.java	����Աҳaction
    --model
	  ->_JFinalGenerator.java		~~~~���ݿ��ӳ���ļ�������
	  ->_MappingKit.java
	  ->[table_name].java			���ɵ����ݿ����
	  --base
	    ->Base[table_name].java		���ɵ����ݿ����ӿ�
	--order
	  ->OrderController.java		����ҳaction
	--register
	  ->RegisterCOntroller.java		ע��ҳaction
	  ->RegisterValidator.java		ע��ҳ������
	--search
	  ->SearchController.java		�������action
	--shoppingCart
	  ->ShoppingCartController.java	���ﳵaction
	--user
	  ->CatalogController.java		��Ч��
	  ->UserController.java			��Ч��
	--userCenter
	  ->UserCenterController.java	�û�����action
	->BambookConfig.java			~~~~JFinal������
	
	WebRoot
	--css							�����ʽ��
	--fonts							����ͼ��
	--js							�ű�
	--picture						ͼƬ
	--WEB-INF
	->_paginate.html				��ҳ����ģ��
	->bookInfo.html					ͼ����ϸ��Ϣҳ��
	->help.html						����ҳ�棨δ��ɣ�
	->index.html					��ҳ
	->introducation.html			�Ƽ�ҳ��δ��ɣ�
	->login.html					��¼ҳ
	->managerCenter.html			����Աҳ��δ��ɣ�
	->order.html					��������
	->register.html					ע��ҳ��
	->searchResult.html				�������ҳ
	->userCenter.html				�û�����ҳ