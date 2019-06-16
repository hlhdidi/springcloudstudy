package com.hlhdidi.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface ISender {

	@Output("xyy-hlhdidi-exchange") SubscribableChannel send();
}
