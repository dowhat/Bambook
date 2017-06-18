package com.bambook.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		test memcached
*/
public class MemcachedJava {
   public static void main(String[] args) {
      try{
         // 本地连接 Memcached 服务
         MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
         System.out.println("Connection to server sucessful.");
         
         // 存储数据
         @SuppressWarnings("rawtypes")
		Future fo = mcc.set("runoob", 900, "Free Education");
      
         // 查看存储状态
         System.out.println("set status:" + fo.get());
         
         // 输出值
         System.out.println("runoob value in cache - " + mcc.get("runoob"));
         // 关闭连接
         mcc.shutdown();
         
      }catch(Exception ex){
         System.out.println( ex.getMessage() );
      }
   }
}