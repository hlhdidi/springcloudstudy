package com.myxyy.web;

import com.hlhdidi.entity.User;
import com.myxyy.service.HystrixCollapseService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
public class HystrixCollapseController {

	@Autowired HystrixCollapseService hystrixCollapseService;

	@RequestMapping(value = "testCollapse")
	@ResponseBody
	public Object testCollapse() throws ExecutionException, InterruptedException {
		HystrixRequestContext context = HystrixRequestContext.initializeContext();
		Future<User> map1 = hystrixCollapseService.findUser(1L);
		Future<User> map2 = hystrixCollapseService.findUser(2L);
		Future<User> map3 = hystrixCollapseService.findUser(3L);
		Future<User> map4 = hystrixCollapseService.findUser(4L);
		Future<User> map5 = hystrixCollapseService.findUser(5L);
		System.out.println("~~map1" + map1.get());
		System.out.println("~~map2" + map2.get());
		System.out.println("~~map3" + map3.get());
		System.out.println("~~map4" + map4.get());
		System.out.println("~~map5" + map5.get());
		context.close();
		return "objk";
	}
}
