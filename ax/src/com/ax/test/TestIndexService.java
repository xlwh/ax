package com.ax.test;

import org.junit.Test;

import com.ax.service.sys.IndexService;

public class TestIndexService extends BaseTest{
	
	@Test
	public void testGetBannerInfo(){
		IndexService service = (IndexService)ctx.getBean("indexServiceImpl");
		service.getBannerInfo(4, 100, 100);
	}
}
