package org.akhi.spring.web;


import org.akhi.spring.dao.ExchangeValueRepository;
import org.akhi.spring.model.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepository repo;
	
	@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from")String from ,@PathVariable("to") String to) {
			
		ExchangeValue exchangeValue = repo.findByFromAndTo(from,to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		logger.info("{}",exchangeValue);
		
		return exchangeValue;
		
	}
}
