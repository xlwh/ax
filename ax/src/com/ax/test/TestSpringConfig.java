package com.ax.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringConfig {
	@SuppressWarnings("resource")
	@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringConfig cfg = (SpringConfig)ctx.getBean("springConfig");
		cfg.say();
	}
}
