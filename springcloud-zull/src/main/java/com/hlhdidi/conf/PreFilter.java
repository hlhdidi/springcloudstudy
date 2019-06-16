package com.hlhdidi.conf;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class PreFilter extends ZuulFilter {

	@Override public String filterType() {
		return "pre";
	}

	@Override public int filterOrder() {
		return 0;
	}

	@Override public boolean shouldFilter() {
		return true;
	}

	@Override public Object run() throws ZuulException {
		System.out.println("至少我进来了,你呢?");
		if(2/1==2) {
			throw new RuntimeException("1123");
		}
		return null;
	}
}
