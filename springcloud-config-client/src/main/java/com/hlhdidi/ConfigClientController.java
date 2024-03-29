package com.hlhdidi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class ConfigClientController {

	@Value("${from}")
	private String from;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "configClient")
	@ResponseBody
	public Object configClient() {
		logger.info("12333333");
		return from;
	}
}
