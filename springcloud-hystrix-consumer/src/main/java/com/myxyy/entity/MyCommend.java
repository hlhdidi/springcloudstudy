package com.myxyy.entity;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.web.client.RestTemplate;

public class MyCommend extends HystrixCommand<String> {

	RestTemplate restTemplate;
	private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey. Factory. asKey("CommandKey");

	public MyCommend() {
		// 设置命令组和线程组,命令组是为了方便统计,可以统计该组内命令的报警以及仪表盘等信息,线程组是为了实现线程池的隔离
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CmmandGroupKey"))
				.andCommandKey(GETTER_KEY)
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")));

	}

	@Override protected String run() throws Exception {
		System.err.println("调用了run方法,好慢好慢");
		String forObject  =
					restTemplate.getForObject("http://hlhdidi-hystrix-server/home", String.class);
		return forObject;
	}

	@Override protected String getFallback() {
		// 获取异常
		Throwable executionException = getExecutionException();
		System.out.println(executionException.getMessage());
		return "error";
	}

	@Override protected String getCacheKey() {
		return "thiscache";
	}

	public static void flashCacheKey() {
		HystrixRequestCache.getInstance(GETTER_KEY,HystrixConcurrencyStrategyDefault.getInstance())
				.clear("thiscache");
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
