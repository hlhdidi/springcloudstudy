package com.hlhdidi.web;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LocalController implements ErrorController {



	/**
	 * 出异常后进入该方法，交由下面的方法处理
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public Object error() {
		RequestContext ctx = RequestContext.getCurrentContext();
		ZuulException exception = (ZuulException) ctx.getThrowable();
		Map<String,Object> map = new HashMap<>();
		map.put("msg",exception.getMessage());
		map.put("err",500);
		return map;
	}
}
