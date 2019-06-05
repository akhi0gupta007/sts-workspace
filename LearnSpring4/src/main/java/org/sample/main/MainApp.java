package org.sample.main;

import org.sample.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		TestService bean = ctx.getBean(TestService.class);
		bean.doService();
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
