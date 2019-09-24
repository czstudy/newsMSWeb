/**
 * 
 */
package com.newsMS.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.newsMS.dto.News;

/**
 * @author Administrator
 *
 */
public class JsonChangeUtil {

	public static String jsonFromList(ArrayList<News> newsList){
		JsonArray  jsonArray=new JsonArray();
		
		try {
			
			for (int i = 0; i < newsList.size(); i++) {
				JsonObject jsonNews = new JsonObject();
				News news = newsList.get(i);
				jsonNews.addProperty("newsId", news.getNewsId());
				jsonNews.addProperty("title", news.getTitle());
				
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String result = df.format(news.getSendTime());
							
				jsonNews.addProperty("sendTime",result);
			
				jsonArray.add(jsonNews);
			}
			return jsonArray.toString();	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
				
	}
	
	
	public static String jsonFromListUseGson(ArrayList<News> list){
		Gson gson = new Gson();		
		String jsonStr="";
		jsonStr=gson.toJson(list,new TypeToken<List<News>>() {}.getType());		
		return jsonStr;
	}
	
	public static String jsonFromNewsUseGson(News news){
		Gson gson=null;
		gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String jsonStrNews=null;
		jsonStrNews=gson.toJson(news,News.class);
		return jsonStrNews;
	}
}
