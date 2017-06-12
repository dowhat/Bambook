package com.bambook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

/**
 * solr工具类
 * 
 * @author xueyu
 * @time 2017.6.9
 */
public class SolrUtil {
    private static SolrClient client;
    private static String url;
    static {
        url = "http://localhost:8983/solr/bambook";
        client = new HttpSolrClient.Builder(url).build();
    }

    /**
     * save or refresh solr date
     * full import
     * @param res
     */
    public static boolean updateSolrdate() {

    	try {
            URL url = new URL(" http://localhost:8983/solr/bambook/dataimport?command=full-import");
            URLConnection URLconnection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.err.println("成功");   
                InputStream in = httpConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader bufr = new BufferedReader(isr);
                String str;
                while ((str = bufr.readLine()) != null) {
                    System.out.println(str);
                }
                bufr.close();
            } else {
                System.err.println("失败");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * delete solr date
     * 
     * @param id
     */
    public static boolean removeSolrData(String id) {
        try {
            client.deleteById(id);
            client.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
     /**
     * search
     * 
     * @param keywords,field
     */
    public static QueryResponse query(String keywords, String field) throws SolrServerException, IOException {
        SolrQuery query = new SolrQuery();
        query.setQuery("book:" + keywords + "or abstracts:" + keywords + "or writer:" + keywords + "or pubFirm:" + keywords);
        query.setHighlight(true);
        query.addHighlightField("writer");
        query.addHighlightField("pubFirm");
        query.addHighlightField("abstracts");
        query.addHighlightField("book");
//        query.setHighlightSnippets(5);
//        query.setHighlightFragsize(50);
        query.setSort(field, SolrQuery.ORDER.asc);
        query.setHighlightSimplePre("<font color='red'>");
        query.setHighlightSimplePost("</font>");
        QueryResponse rsp = client.query(query);
        return rsp;
    }

}