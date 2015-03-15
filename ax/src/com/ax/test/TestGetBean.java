package com.ax.test;

import org.junit.Test;

import com.ax.service.sys.IndexService;

public class TestGetBean extends BaseTest{
	@SuppressWarnings("unused")
	@Test
	public void getBean(){
		IndexService service = (IndexService)ctx.getBean("indexServiceImpl");
		//Map<String,Object> res = service.goIndex(0,0,0);
		//System.out.println(res.toString());
	}
}
