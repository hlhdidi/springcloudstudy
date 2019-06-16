package com.myxyy.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerService {

	@HystrixCommand(fallbackMethod = "testCircuitBreakError")
	public String testCircuitBreak(Integer i) {
		if(i != null && i.equals(1)) {
			throw new RuntimeException("报错了");
		}
		return "ok";
	}

	@HystrixCommand
	public String testCircuitBreakError(Integer i) {
		return "error";
	}
}
