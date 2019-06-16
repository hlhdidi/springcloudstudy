package com.hlhdidi.web;

import com.hlhdidi.model.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired Sender sender;

	@RequestMapping(value = "testHello")
	public String testHello(){
		sender.send();
		return "testHello";
	}
}
