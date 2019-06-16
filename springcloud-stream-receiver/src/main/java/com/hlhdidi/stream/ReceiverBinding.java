package com.hlhdidi.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(IReceiver.class)
public class ReceiverBinding {

	@StreamListener("xyy-hlhdidi-exchange")
	public void receive(byte[] chars) {
		System.out.println("receive:" + new String(chars));
	}

}
