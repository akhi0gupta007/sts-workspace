package org.sample.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class TestService implements InitializingBean,DisposableBean{
	public TestService() {
		System.out.println("constructor");
	}

	public void doService() {
		System.out.println("Test Service : doservice");
	}

	public String getService() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, (str1,str2)-> str1.compareTo(str2));
		return "Thanks for our services";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Test Service : afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Test Service : destroy");
		
	}
	
	
}
