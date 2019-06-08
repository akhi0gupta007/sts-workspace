package org.akhi.spring.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() { // should I execute this filter or not ?
		return true;
	}

	@Override
	public Object run() throws ZuulException { // logic of filter

		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() { // when filter should execute, example pre : before request, post : after
									// request or error : dring some error
		return "pre";
	}

	@Override
	public int filterOrder() { // Order of a filter if multiples are present
		return 1;
	}

}
