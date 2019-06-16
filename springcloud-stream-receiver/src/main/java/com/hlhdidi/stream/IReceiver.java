package com.hlhdidi.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface IReceiver {

	@Input("xyy-hlhdidi-exchange") SubscribableChannel receive();
}
