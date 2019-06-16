package com.hlhdidi.model;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

	@Autowired AmqpTemplate amqpTemplate;

	public void send() {
		amqpTemplate.convertAndSend("hello","hello" + new Date());
	}
}
