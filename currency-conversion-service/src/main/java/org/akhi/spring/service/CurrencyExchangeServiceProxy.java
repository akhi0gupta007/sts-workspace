package org.akhi.spring.service;

import org.akhi.spring.model.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "currency-exchange-service",url = "localhost:8000") --old way
@RibbonClient(name = "currency-exchange-service")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from")String from ,@PathVariable("to") String to);
	
}
