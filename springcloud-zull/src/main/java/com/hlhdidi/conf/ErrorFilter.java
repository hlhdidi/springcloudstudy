package com.hlhdidi.conf;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ErrorFilter extends ZuulFilter {

	@Override public String filterType() {
		// 该过滤器在路由前执行
		return "error";
	}

	@Override public int filterOrder() {
		return 10;
	}

	@Override public boolean shouldFilter() {
		return true;
	}

	@Override public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext() ;

		Throwable throwable = ctx.getThrowable();
		ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		ctx.set("error.exception", throwable.getMessage());
		return null;
	}

	private void doSomeThing() {
		throw new RuntimeException("do something!");
	}
}
