package com.ax.test;

import java.util.List;

import org.junit.Test;

import com.ax.bean.BannerInfo;
import com.ax.dao.banner.BannerInfoDao;
import com.ax.exception.DaoException;

public class TestBannerInfoDao extends BaseTest{
	
	
	@Test
	public void testSave(){
		BannerInfoDao dao =(BannerInfoDao)ctx.getBean("bannerInfoDaoImpl");
		for(int i=0;i<10;i++){
			BannerInfo info = new BannerInfo();
			info.setDetail("开发测试");
			info.setPic("http:\\study211.duapp.com\\img\\download");
			info.setFileName("p"+(i+1)+".jpg");
			info.setTitle("测试");
			info.setTitle("活动推荐");
			try {
				dao.save(info);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
   
	public void testGet(){
		BannerInfoDao dao =(BannerInfoDao)ctx.getBean("bannerInfoDaoImpl");
		//System.out.println(dao == null);
		List<BannerInfo> banners = dao.findByNum(5);
        for(int i=0;i<banners.size();i++){
        	BannerInfo info = banners.get(i);
        	System.out.println(info.getId());
        }
    
    }
}
