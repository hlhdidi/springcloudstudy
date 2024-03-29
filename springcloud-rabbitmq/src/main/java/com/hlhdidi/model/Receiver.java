package com.hlhdidi.model;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Receiver {

	@RabbitHandler
	public void handleHello(String hello) {
		System.out.println("receive:" + hello);
	}
}
