package com.hlhdidi.service;

import com.hlhdidi.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "hlhdidi-eureka-client",fallback = HelloServiceFallBack.class)
public interface HelloService {

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public User hello();

	@RequestMapping(value = "hello2")
	@ResponseBody
	public User hello2(@RequestParam(value = "id") Long id,
			@RequestParam(value = "type") String type);

	@RequestMapping(value = "hello3")
	@ResponseBody
	public User hello3(@RequestBody User user);
}
