package org.akhi.spring;

import java.util.concurrent.TimeUnit;

import org.akhi.spring.messaging.Receiver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AngularServerApplicationTests {
	private @Autowired RabbitTemplate rabbitTemplate;
	private @Autowired Receiver receiver;



	@Test
	public void contextLoads() {
		   rabbitTemplate.convertAndSend(MessageConfigurerServer.topicExchangeName, "foo.bar.baz", "Hello test from RabbitMQ!");
		    try {
				receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

}
