package org.akhi.spring.service;

import org.akhi.spring.model.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "currency-exchange-service",url = "localhost:8000") --old way
//@FeignClient(name = "currency-exchange-service") : Deprecated now connecting through Zuul API Gateway to this service
@FeignClient(name="netflix-zuul-api-gateway-server")
//@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	//@RequestMapping("/currency-exchange/from/{from}/to/{to}") //Now URL must be changed after Zuul gateway
	@RequestMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from")String from ,@PathVariable("to") String to);
	
}
