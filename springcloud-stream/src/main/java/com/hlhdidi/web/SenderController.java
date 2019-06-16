package com.hlhdidi.web;

import com.hlhdidi.stream.ISender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

	@Autowired ISender iSender;

	@RequestMapping(value = "sendMsg")
	public String sendMsg() {
		String msg = "xiaodongxi henbiezhi a ~";
		Message<byte[]> message = MessageBuilder.withPayload(msg.getBytes())
				.setHeader("partitionKey",1).build();
		iSender.send().send(message);
		return "success";
	}
}
