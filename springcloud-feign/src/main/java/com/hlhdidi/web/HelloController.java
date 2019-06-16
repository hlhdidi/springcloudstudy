package com.hlhdidi.web;

import com.hlhdidi.entity.User;
import com.hlhdidi.service.HelloService;
import com.hlhdidi.service.HelloServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HelloController {

	@Autowired HelloService helloService;
	@Autowired HelloServiceWrapper helloServiceWrapper;

	@RequestMapping(value = "hello",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public User hello() {
		return helloService.hello();
	}
	@RequestMapping(value = "hello2",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public User hello2() {
		User hello = helloService.hello2(-1L,"xiaodidi");
		return hello;
	}
	@RequestMapping(value = "hello3",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public User hello3() {
		User paramUser = new User();
		paramUser.setId(10L);
		paramUser.setType("type~~~");
		paramUser.setCtime(new Date());
		User hello = helloService.hello3(paramUser);
		return hello;
	}
}
