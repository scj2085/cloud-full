package com.cloud.approve_zuul.filter.post;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PostFilter extends ZuulFilter{

	Logger log = LoggerFactory.getLogger(PostFilter.class);
	
	@Override
	public Object run() {
		log.info("this is a post filter: Receive response");
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
		try {
			response.getOutputStream().print(", I am ***************");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.flushBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 2000;
	}

	@Override
	public String filterType() {
		
		return "post";
	}

}
