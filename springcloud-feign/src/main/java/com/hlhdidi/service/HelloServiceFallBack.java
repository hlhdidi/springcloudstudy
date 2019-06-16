package com.hlhdidi.service;

import com.hlhdidi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallBack implements HelloService {

	@Override public User hello() {
		User user = new User();
		user.setId(-1L);
		user.setType("error");
		return user;
	}

	@Override public User hello2(Long id, String type) {
		User user = new User();
		user.setId(-1L);
		user.setType("error");
		return user;
	}

	@Override public User hello3(User user) {
		User user1 = new User();
		user1.setId(-1L);
		user1.setType("error");
		return user1;
	}
}
