package com.myxyy.web;

import com.myxyy.service.HystrixConsumerService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * 演示hystrix,hystrixcache
 */
@Controller
public class HystrixConsumerController {

	@Autowired HystrixConsumerService hystrixConsumerService;


	@RequestMapping(value = "testRibbon")
	@ResponseBody
	public Object testRibbon() {
		HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();
		// not cache
		hystrixConsumerService.testRibbonDo();
		// cache
		hystrixConsumerService.testRibbonDo();
		// remove
		hystrixConsumerService.testRibbonRemove();
		// not cache
		hystrixConsumerService.testRibbonDo();
		// cache
		hystrixConsumerService.testRibbonDo();
		return "home";
	}
}
