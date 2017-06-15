package com.bambook;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import redis.clients.jedis.Jedis;


public class SolrService {

	public SolrDocumentList search(String temp, String field) {	
		try {
	        //test date import
	        SolrUtil.updateSolrdate();
	        
	        //search book
	        QueryResponse respone = SolrUtil.query(temp, field);
//	        Jedis jedis = new Jedis("localhost");
	        System.out.println(respone);
	        SolrDocumentList docs = respone.getResults();
	        Map<String, Map<String, List<String>>> map = respone.getHighlighting();
	        System.out.println(map);
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        // set Highlight
	        for(SolrDocument doc: docs){
	        	if(map.get(doc.getFieldValue("bookID").toString()).get("book") != null){
	        		doc.setField("book", map.get(doc.getFieldValue("bookID").toString()).get("book").get(0));
	        	}
	        	if(map.get(doc.getFieldValue("bookID").toString()).get("abstracts") != null){
//highlight fragments:set fragmentSeparator "..."
//	        		int i = map.get(doc.getFieldValue("bookID").toString()).get("abstracts").size();
//	        		String abs = "";
//	        		String fragmentSeparator = "<strong>...</strong>";
//	        		for(int j = 0; j< i; j++){
//	        			abs += map.get(doc.getFieldValue("bookID").toString()).get("abstracts").get(j);
//	        			System.out.println(map.get(doc.getFieldValue("bookID").toString()).get("abstracts").get(j));
//	        			if(map.get(doc.getFieldValue("bookID").toString()).get("abstracts").get(j).length() <= 80){
//	        				abs += fragmentSeparator;
//	        			}
//	        		}
//	        		doc.setField("abstracts", abs);
	        		doc.setField("abstracts", map.get(doc.getFieldValue("bookID").toString()).get("abstracts").get(0));
	        	}
	        	// change date from GMT format to yyyy-mm-dd format
	        	doc.setField("pubTime", sdf.format(doc.getFieldValue("pubTime")));
	        }
	        return docs;
	    } catch (SolrServerException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return null;
	}

}
