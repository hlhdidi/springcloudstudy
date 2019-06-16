package com.myxyy.service;

import com.hlhdidi.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@Service
public class HystrixCollapseService {

	@Autowired RestTemplate restTemplate;

	@HystrixCollapser(batchMethod= "findAllUsers", collapserProperties=
			{
					@HystrixProperty(name="timerDelayInMilliseconds", value = "9000")
			}
			)
	public Future<User> findUser(Long id) {
		return null;
	}

	@HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")})
	public List<User> findAllUsers(List<Long> ids) {
		System.out.println("maps~collapese");
		ParameterizedTypeReference<List<User>> responseType = new ParameterizedTypeReference<List<User>>(){};

		ResponseEntity<List<User>> exchanges = restTemplate
				.exchange("http://hlhdidi-hystrix-server/getUsers/{1}", HttpMethod.GET, null,
						responseType, StringUtils.join(ids, ","));
		System.out.println("mapslist:" + exchanges.getBody());
		return exchanges.getBody();
	}
}
