package com.ax.test;

import org.junit.Test;

import com.ax.utils.ConfigReader;

public class TestConfigReader extends BaseTest{
	@Test
	public void testReader(){
		ConfigReader reader = (ConfigReader)ctx.getBean("configReader");
		System.out.println(reader.getImageDir());
	}
}
