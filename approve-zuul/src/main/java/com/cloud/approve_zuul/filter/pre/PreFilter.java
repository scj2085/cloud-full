package com.cloud.approve_zuul.filter.pre;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter{

	Logger log = LoggerFactory.getLogger(PreFilter.class);	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		log.info("this is a pre filter:Send {} request to {]",request.getMethod(),request.getRequestURI().toString());
		return null;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1000;
	}

}
