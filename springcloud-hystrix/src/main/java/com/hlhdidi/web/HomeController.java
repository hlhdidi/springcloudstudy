package com.hlhdidi.web;

import com.hlhdidi.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class HomeController {
	@RequestMapping(value = "home")
	public String home(HttpServletResponse response) {
		return "home";
	}

	@RequestMapping(value = "getUser/{userId}")
	public User getUser(@PathVariable("userId")Long userId,HttpServletRequest request) {
		User user = new User();
		user.setId(userId);
		user.setType("single");
		user.setCtime(new Date());
		return user;
	}

	@RequestMapping(value = "getUsers/{userIds}")
	public List<User> getUsers(@PathVariable("userIds")String userIds) {
		System.out.println("aaaaa不要调用老子了");
		String[] userIdStrs = userIds.split(",");
		List<User> mapList = new ArrayList<>();
		for(String userIdStr : userIdStrs) {
			User user = new User();
			user.setId(Long.parseLong(userIdStr));
			user.setType("multi");
			user.setCtime(new Date());
			mapList.add(user);
		}
		return mapList;
	}
}
