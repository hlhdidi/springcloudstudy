package com.hlhdidi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class RibbonController {

	@Autowired RestTemplate restTemplate;

	@RequestMapping(value = "testRibbon")
	@ResponseBody
	public Object testRibbon() {
		String forObject =
				restTemplate.getForObject("http://hlhdidi-eureka-client/hello", String.class);
		return forObject;
	}
}
