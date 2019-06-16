package com.myxyy.service;


import com.myxyy.entity.MyCommend;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixConsumerService {

	@Autowired RestTemplate restTemplate;

	public String testRibbon() {
		testRibbonDo();
		testRibbonDo();
		testRibbonDo();
		return "home";
	}

	@HystrixCommand(fallbackMethod = "error")
	@CacheResult(cacheKeyMethod = "getCachekey")
	public String testRibbonDo() {
		System.out.println("执行了的说!");
		String forObject =
				restTemplate.getForObject("http://hlhdidi-hystrix-server/home", String.class);
		return forObject;
	}

	@HystrixCommand
	@CacheRemove(commandKey = "testRibbonDo",cacheKeyMethod = "getCachekey")
	public String testRibbonRemove() {
		System.out.println("removeremove");
		return "ok";
	}

	public String error(Throwable e) {
		System.out.println("曹乐" + e.getMessage());
		return "error";
	}

	private String getCachekey() {
		return "cache_key";
	}
}
