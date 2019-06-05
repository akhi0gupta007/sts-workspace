package org.akhi.spring.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.akhi.spring.model.CurrencyConversionBean;
import org.akhi.spring.service.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@RequestMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);

		return new CurrencyConversionBean(response.getBody().getId(), from, to,
				response.getBody().getConversionMultiple(), quantity, quantity.multiply(response.getBody().getConversionMultiple()), response.getBody().getPort());

	}
	
	@RequestMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFein(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

		return new CurrencyConversionBean(response.getId(), from, to,
				response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());

	}
}
