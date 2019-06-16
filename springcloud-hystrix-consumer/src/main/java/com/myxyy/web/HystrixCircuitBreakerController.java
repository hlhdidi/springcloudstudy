package com.myxyy.web;

import com.myxyy.service.CircuitBreakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HystrixCircuitBreakerController {

	@Autowired CircuitBreakerService circuitBreakerService;

	@RequestMapping(value = "testCircuitBreak")
	@ResponseBody
	public Object testCircuitBreak(@RequestParam(value = "i")Integer i) {
		String j = circuitBreakerService.testCircuitBreak(i);
		return j;
	}
}
