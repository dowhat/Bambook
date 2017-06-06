/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : onlinebookcenter

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-06-02 15:17:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addressID` int(20) NOT NULL DEFAULT '0',
  `userName` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `postcode` int(10) DEFAULT NULL,
  `telephone` int(20) DEFAULT NULL,
  PRIMARY KEY (`addressID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', 'user', '李磊', '湖北省武汉市华中科技大学南二舍', '430000', '1314520');
INSERT INTO `address` VALUES ('2', 'user', '李明', '江西省赣州市南康区', '341400', '798384609');

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `bookID` int(20) NOT NULL,
  `ISBN` varchar(20) DEFAULT NULL,
  `book` varchar(50) DEFAULT NULL,
  `writer` varchar(50) DEFAULT NULL,
  `pubFirm` varchar(20) DEFAULT NULL,
  `pubTime` date DEFAULT NULL,
  `catalogID` int(10) DEFAULT NULL,
  `price` float(10,1) DEFAULT NULL,
  `stock` int(10) DEFAULT NULL,
  `abstract` varchar(100) DEFAULT NULL,
  `sales` int(10) DEFAULT NULL,
  `picture` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('1', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-22', '101', '1.0', '7', '正版2017使用高中语文必修4课本书教材教科书人民教育出版社高一下册高中语文必修四课本', '1', 'book.min3.jpg');
INSERT INTO `bookinfo` VALUES ('2', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-21', '101', '2.0', '7', '1', '2', 'book.min2.jpg');
INSERT INTO `bookinfo` VALUES ('3', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-20', '103', '3.0', '7', '1', '3', 'book.min1.jpg');
INSERT INTO `bookinfo` VALUES ('4', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-19', '101', '4.0', '7', '1', '4', 'book.min5.jpg');
INSERT INTO `bookinfo` VALUES ('5', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-20', '101', '5.0', '7', '11', '5', 'book.min6.jpg');
INSERT INTO `bookinfo` VALUES ('6', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-22', '101', '6.0', '7', '1', '6', 'book.min7.jpg');
INSERT INTO `bookinfo` VALUES ('7', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-09', '101', '7.0', '7', '1', '7', 'book.min8.jpg');
INSERT INTO `bookinfo` VALUES ('8', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-02', '102', '8.0', '7', '1', '8', 'book.min1.jpg');
INSERT INTO `bookinfo` VALUES ('9', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-10', '101', '9.0', '7', '1', '11', 'book.min2.jpg');
INSERT INTO `bookinfo` VALUES ('10', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-05', '101', '0.0', '7', '1', '11', 'book.min3.jpg');
INSERT INTO `bookinfo` VALUES ('11', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-26', '101', '1.0', '77', '1', '13', 'book.min4.jpg');
INSERT INTO `bookinfo` VALUES ('12', '1', '高一语文', '刘明', '人民邮电出版社', '2017-05-15', '101', '2.0', '7', '1', '4', 'book.min3.jpg');
INSERT INTO `bookinfo` VALUES ('13', '1', 'fdsklj', '324', '532', '2017-05-23', '101', '1.0', '1', '1', '1', 'book.min3.jpg');
INSERT INTO `bookinfo` VALUES ('14', '1', '233254', '345', '235', '2017-05-16', '101', '1.0', '1', '1', '1', 'book.min3.jpg');
INSERT INTO `bookinfo` VALUES ('15', '1', '高一数学', '李明', '北方妇女儿童出版社', '2017-05-03', '101', '2.0', '1', '2', '3', 'book.min5.jpg');
INSERT INTO `bookinfo` VALUES ('16', '2', '择天记', '猫腻', '南方出版社', '2017-05-16', '102', '5.0', '6', '鹿晗、古力娜扎领衔主演同名电视剧正在热播。猫腻原著小说，人气榜冠军，讲述少年陈长生十四岁逆天改命的崛起历程。北大教授邵燕君、著名编剧史航热烈推荐', '43', 'book.min1.jpg');

-- ----------------------------
-- Table structure for bookreview
-- ----------------------------
DROP TABLE IF EXISTS `bookreview`;
CREATE TABLE `bookreview` (
  `reviewID` int(20) NOT NULL AUTO_INCREMENT,
  `bookID` int(20) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `level` int(2) DEFAULT NULL,
  `reviews` varchar(100) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `remarks` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`reviewID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookreview
-- ----------------------------
INSERT INTO `bookreview` VALUES ('1', '1', 'user', '5', '语文好啊', '2017-05-22 00:00:00', 'yu');
INSERT INTO `bookreview` VALUES ('2', '2', 'user', '4', 'yuldskf', '2017-05-22 00:00:00', '56');
INSERT INTO `bookreview` VALUES ('3', '15', '刘明', '4', '数学好啊', '2017-05-23 21:34:35', 'jflk');
INSERT INTO `bookreview` VALUES ('4', '15', 'admin', '3', '数学真好啊', '2017-05-11 21:35:15', 'dsf');
INSERT INTO `bookreview` VALUES ('5', '15', 'lll', '4', '看不到', '2017-05-02 21:37:45', '43');
INSERT INTO `bookreview` VALUES ('6', '15', 'dsfsdg', '5', '看不懂', '2017-05-05 21:37:49', '34');
INSERT INTO `bookreview` VALUES ('7', '15', 'dsfgf', '4', '看不得', '2017-05-09 21:37:52', '5');
INSERT INTO `bookreview` VALUES ('8', '15', 'fsdg', '2', '砍不动', '2017-05-10 21:37:57', '4');
INSERT INTO `bookreview` VALUES ('9', '15', 'dsfd', '3', '恐怖的', '2017-05-09 21:38:00', '54');
INSERT INTO `bookreview` VALUES ('10', '15', 'terg', '4', '开不到', '2017-05-06 21:38:03', '3');
INSERT INTO `bookreview` VALUES ('11', '15', 'sdfagd', '5', '可拨打', '2017-05-13 21:38:07', 'f');
INSERT INTO `bookreview` VALUES ('12', '15', 'hdf', '4', '苦逼的', '2017-02-15 21:38:11', 'f');
INSERT INTO `bookreview` VALUES ('13', '15', 'tr', '3', '空白的', '2017-04-12 21:38:17', null);

-- ----------------------------
-- Table structure for maincatalog
-- ----------------------------
DROP TABLE IF EXISTS `maincatalog`;
CREATE TABLE `maincatalog` (
  `mCatalogID` int(10) NOT NULL,
  `mCatalogName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mCatalogID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maincatalog
-- ----------------------------
INSERT INTO `maincatalog` VALUES ('1', '教育');
INSERT INTO `maincatalog` VALUES ('2', '电子书');
INSERT INTO `maincatalog` VALUES ('3', '小说');
INSERT INTO `maincatalog` VALUES ('4', '文艺');
INSERT INTO `maincatalog` VALUES ('5', '青春文学/动漫幽默');
INSERT INTO `maincatalog` VALUES ('6', '童书');
INSERT INTO `maincatalog` VALUES ('7', '生活');
INSERT INTO `maincatalog` VALUES ('8', '人文社科');
INSERT INTO `maincatalog` VALUES ('9', '经管');
INSERT INTO `maincatalog` VALUES ('10', '励志/成功');
INSERT INTO `maincatalog` VALUES ('11', '科技');
INSERT INTO `maincatalog` VALUES ('12', '外文原版');
INSERT INTO `maincatalog` VALUES ('13', '期刊/音像');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `orderID` int(20) DEFAULT NULL,
  `userName` varchar(20) NOT NULL,
  `orderDate` date DEFAULT NULL,
  `bookID` int(20) NOT NULL,
  `orderNumber` int(10) NOT NULL,
  `orderStatus` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('12', '1', 'user', '2017-05-22', '1', '1', '交易成功');
INSERT INTO `orders` VALUES ('13', '2', 'user', '2017-05-21', '2', '1', '交易关闭');
INSERT INTO `orders` VALUES ('14', '3', 'admin', '2017-05-26', '1', '1', '待付款');
INSERT INTO `orders` VALUES ('15', '4', 'admin', '2017-05-26', '1', '1', '待发货');
INSERT INTO `orders` VALUES ('16', '5', 'admin', '2017-05-26', '1', '1', '待收货');
INSERT INTO `orders` VALUES ('17', '8', 'admin', '2017-05-26', '1', '1', '待评价');
INSERT INTO `orders` VALUES ('18', '9', '你好', '2017-05-26', '2', '1', '交易关闭');
INSERT INTO `orders` VALUES ('19', '10', 'admin', '2017-05-26', '7', '1', '交易关闭');
INSERT INTO `orders` VALUES ('20', '9', '你好', '2017-05-26', '12', '1', '交易关闭');
INSERT INTO `orders` VALUES ('21', '2', 'user', '2017-05-22', '6', '2', '交易关闭');
INSERT INTO `orders` VALUES ('22', '11', 'mw', '2017-05-31', '1', '1', '交易成功');
INSERT INTO `orders` VALUES ('23', '11', 'mw', '2017-05-31', '1', '1', '交易成功');
INSERT INTO `orders` VALUES ('24', '1550467904', 'mw', '2017-05-31', '16', '1', '交易成功');

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `cartID` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `bookID` int(20) NOT NULL,
  `number` int(5) NOT NULL,
  PRIMARY KEY (`cartID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES ('3', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('4', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('5', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('6', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('7', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('8', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('9', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('10', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('11', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('12', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('13', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('14', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('15', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('16', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('17', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('18', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('19', '你好', '1', '1');
INSERT INTO `shoppingcart` VALUES ('20', 'admin', '15', '1');
INSERT INTO `shoppingcart` VALUES ('21', '你好', '15', '1');
INSERT INTO `shoppingcart` VALUES ('29', 'mw', '1', '1');
INSERT INTO `shoppingcart` VALUES ('30', 'mw', '1', '1');
INSERT INTO `shoppingcart` VALUES ('31', 'user', '16', '3');
INSERT INTO `shoppingcart` VALUES ('32', 'user', '1', '1');
INSERT INTO `shoppingcart` VALUES ('33', 'user', '3', '1');
INSERT INTO `shoppingcart` VALUES ('34', 'user', '2', '1');
INSERT INTO `shoppingcart` VALUES ('35', 'user', '1', '1');
INSERT INTO `shoppingcart` VALUES ('36', 'user', '1', '1');

-- ----------------------------
-- Table structure for subcatalog
-- ----------------------------
DROP TABLE IF EXISTS `subcatalog`;
CREATE TABLE `subcatalog` (
  `sCatalogID` int(10) NOT NULL,
  `sCatalogName` varchar(20) DEFAULT NULL,
  `mCatalogID` int(10) DEFAULT NULL,
  PRIMARY KEY (`sCatalogID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subcatalog
-- ----------------------------
INSERT INTO `subcatalog` VALUES ('101', '教材', '1');
INSERT INTO `subcatalog` VALUES ('102', '外语', '1');
INSERT INTO `subcatalog` VALUES ('103', '考试', '1');
INSERT INTO `subcatalog` VALUES ('104', '中小学教辅', '1');
INSERT INTO `subcatalog` VALUES ('105', '工具书', '1');
INSERT INTO `subcatalog` VALUES ('201', '网络文学', '2');
INSERT INTO `subcatalog` VALUES ('202', '小说', '2');
INSERT INTO `subcatalog` VALUES ('301', '中国当代小说', '3');
INSERT INTO `subcatalog` VALUES ('302', '中国近现代小说', '3');
INSERT INTO `subcatalog` VALUES ('303', '中国古典小说', '3');
INSERT INTO `subcatalog` VALUES ('304', '四大名著', '3');
INSERT INTO `subcatalog` VALUES ('305', '港澳台小说', '3');
INSERT INTO `subcatalog` VALUES ('306', '外国小说', '3');
INSERT INTO `subcatalog` VALUES ('401', '文学', '4');
INSERT INTO `subcatalog` VALUES ('402', '传记', '4');
INSERT INTO `subcatalog` VALUES ('403', '艺术', '4');
INSERT INTO `subcatalog` VALUES ('404', '摄影', '4');
INSERT INTO `subcatalog` VALUES ('501', '青春文学', '5');
INSERT INTO `subcatalog` VALUES ('502', '动漫·幽默', '5');
INSERT INTO `subcatalog` VALUES ('601', '0-2', '6');
INSERT INTO `subcatalog` VALUES ('602', '3-6', '6');
INSERT INTO `subcatalog` VALUES ('603', '7-10', '6');
INSERT INTO `subcatalog` VALUES ('604', '11-14', '6');
INSERT INTO `subcatalog` VALUES ('605', '科普/百科', '6');
INSERT INTO `subcatalog` VALUES ('606', '绘本', '6');
INSERT INTO `subcatalog` VALUES ('607', '文学', '6');
INSERT INTO `subcatalog` VALUES ('608', '英语', '6');
INSERT INTO `subcatalog` VALUES ('701', '孕期', '7');
INSERT INTO `subcatalog` VALUES ('702', '两性', '7');
INSERT INTO `subcatalog` VALUES ('703', '育儿/早教', '7');
INSERT INTO `subcatalog` VALUES ('704', '亲子/家教', '7');
INSERT INTO `subcatalog` VALUES ('705', '保健', '7');
INSERT INTO `subcatalog` VALUES ('706', '运动', '7');
INSERT INTO `subcatalog` VALUES ('707', '美妆', '7');
INSERT INTO `subcatalog` VALUES ('708', '手工/DIY', '7');
INSERT INTO `subcatalog` VALUES ('709', '美食', '7');
INSERT INTO `subcatalog` VALUES ('710', '旅游', '7');
INSERT INTO `subcatalog` VALUES ('711', '休闲', '7');
INSERT INTO `subcatalog` VALUES ('712', '家庭/家居', '7');
INSERT INTO `subcatalog` VALUES ('713', '风水/占卜', '7');
INSERT INTO `subcatalog` VALUES ('801', '历史', '8');
INSERT INTO `subcatalog` VALUES ('802', '古籍', '8');
INSERT INTO `subcatalog` VALUES ('803', '哲学/宗教', '8');
INSERT INTO `subcatalog` VALUES ('804', '文化', '8');
INSERT INTO `subcatalog` VALUES ('805', '政治/军事', '8');
INSERT INTO `subcatalog` VALUES ('806', '法律', '8');
INSERT INTO `subcatalog` VALUES ('807', '社会科学', '8');
INSERT INTO `subcatalog` VALUES ('808', '心理学', '8');
INSERT INTO `subcatalog` VALUES ('901', '经济', '9');
INSERT INTO `subcatalog` VALUES ('902', '管理', '9');
INSERT INTO `subcatalog` VALUES ('903', '投资理财', '9');
INSERT INTO `subcatalog` VALUES ('1001', '励志', '10');
INSERT INTO `subcatalog` VALUES ('1002', '成功', '10');
INSERT INTO `subcatalog` VALUES ('1101', '科普', '11');
INSERT INTO `subcatalog` VALUES ('1102', '建筑', '11');
INSERT INTO `subcatalog` VALUES ('1103', '医学', '11');
INSERT INTO `subcatalog` VALUES ('1104', '计算机', '11');
INSERT INTO `subcatalog` VALUES ('1105', '农林', '11');
INSERT INTO `subcatalog` VALUES ('1106', '自然科学', '11');
INSERT INTO `subcatalog` VALUES ('1107', '工业', '11');
INSERT INTO `subcatalog` VALUES ('1201', '英文原版', '12');
INSERT INTO `subcatalog` VALUES ('1202', '港台图书', '12');
INSERT INTO `subcatalog` VALUES ('1301', '期刊', '13');
INSERT INTO `subcatalog` VALUES ('1302', '音像', '13');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userID` int(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `telephone` int(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'user', 'user', '123456', '123456', '123456');
INSERT INTO `userinfo` VALUES ('2', 'admin', 'admin', '123456', '12455', '12323454');
INSERT INTO `userinfo` VALUES ('3', 'user', 'user2', '123456', '11111', '11111');
INSERT INTO `userinfo` VALUES ('24', 'user', '你好', '123', null, 'user');
INSERT INTO `userinfo` VALUES ('25', 'user', 'uuuser', '123456', null, null);
INSERT INTO `userinfo` VALUES ('26', 'user', 'uuu', '123456', null, null);
INSERT INTO `userinfo` VALUES ('27', 'user', 'mw', '123456', null, null);
INSERT INTO `userinfo` VALUES ('28', 'user', 'tianxia', '123456', null, null);
