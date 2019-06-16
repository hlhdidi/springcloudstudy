package com.hlhdidi.service;

import com.hlhdidi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class HelloServiceWrapper {

	@Autowired HelloService helloService;

	public User hello() {
		return helloService.hello();
	}


	public User hello2( Long id, String type) {
		return helloService.hello2(id,type);
	}


	public User hello3( User user) {
		return helloService.hello3(user);
	}
}
