package com.bambook.util;

import java.util.List;

import com.bambook.model.Maincatalog;

import redis.clients.jedis.Jedis;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		test redis, use this class to edit the redis cache
*/
public class RedisJava {
   public static void main(String[] args) {
      //连接本地的 Redis 服务
      try{
    	  Jedis jedis = new Jedis("localhost");
          System.out.println("Connection to server sucessfully");
          //查看服务是否运行
          //redis string
          jedis.set("test", "smartian");
//          System.out.println("Server is running: "+jedis.ping());
          System.out.println("test jedis get key:" + jedis.get("test"));
          //redis list
          jedis.lpush("hotSearch", "Java Web");
          jedis.lpush("hotSearch", "C++");
          jedis.lpush("hotSearch", "择天记");
          jedis.lpush("hotSearch", "刘明");

          jedis.lpush("activity", "activity1.jpg", "activity2.jpg", "activity3.jpg");
//          List<String> list = jedis.lrange("test-list", 0, 2);
//          for(int i = 0; i < list.size(); i++){
//        	  System.out.println(list.size());
//        	  System.out.println("string "+ i + " get from redis: " + list.get(i));
//          }
          //          jedis.close();
          
          //redis keys
//          Set<String> keys = jedis.keys("*");
//          Iterator<String> it = keys.iterator();
//          while(it.hasNext()){
//        	  String key = it.next();
//        	  System.out.println(key);
//          }
      } catch (Exception e){
    	  System.out.println("redis connection failed");
      }
  }
   
   // add Catalog data to cache
   public void addCatalogToRedis(){
 	  Jedis jedis = new Jedis("localhost");
 	  List<Maincatalog> mC = Maincatalog.dao.find("select * from Maincatalog");
   }
}