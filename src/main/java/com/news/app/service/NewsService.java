package com.news.app.service;

import java.io.IOException;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.news.app.model.News;

@Service
public class NewsService extends MappingJackson2HttpMessageConverter {

	private static NewsService ourInstance = new NewsService();

	public static NewsService getInstance() {
		return ourInstance;
	}

	private NewsService() {
		setPrettyPrint(true);
	}

	public static News sendRefinedUpdate(String country,String category,String source123) throws IOException {	

		String urlString = "https://newsapi.org/v2/everything?q=apple&from=2021-09-13&to=2021-09-13&sortBy=popularity&apiKey=6aa2c474003e460b94dc2e4479d45fd2";
		RestTemplate restTemplate = new RestTemplate();
		News response  = restTemplate.getForObject(urlString, News.class);
		return response;


	}

	public static News sendCategorizedUpdate(String country,String category) throws IOException {

		String urlString = "https://newsapi.org/v2/top-headlines?apiKey=a24d98f562554d239d33c2f9d3da0983&country="+country+"&category="+category+"";
		RestTemplate restTemplate = new RestTemplate();
		News response = restTemplate.getForObject(urlString, News.class);	    	
		return response;

	}

	public static News sendSourcedUpdate(String country,String source123) throws IOException {

		String urlString = "https://newsapi.org/v2/top-headlines?apiKey=a24d98f562554d239d33c2f9d3da0983&country="+country+"&source="+source123+"";
		RestTemplate restTemplate = new RestTemplate();
		News response = restTemplate.getForObject(urlString, News.class);
		return response;



	}    

}