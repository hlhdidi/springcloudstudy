package com.hlhdidi.web;

import com.hlhdidi.entity.User;
import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class FirstController {
	@RequestMapping(value = "hello")
	public String hello(HttpServletResponse response) {
		System.out.println("进来了呢");
		if(2/0 == 0) {
			throw new RuntimeException("hello~~~~~~~~mumama");
		}
		return "ok";
	}

	@RequestMapping(value = "hello2")
	@ResponseBody
	public User hello2(@RequestParam(value = "id") Long id,
			@RequestParam(value = "type") String type,HttpServletRequest request) {
		User user = new User();
		user.setId(id);
		user.setType(type);
		return user;
	}
	@RequestMapping(value = "hello3")
	@ResponseBody
	public User hello2(@RequestBody User user) {
		User newUser = new User();
		newUser.setType(user.getType()+"return");
		newUser.setId(user.getId());
		return newUser;
	}
}
