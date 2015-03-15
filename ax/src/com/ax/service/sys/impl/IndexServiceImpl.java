package com.ax.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.ax.bean.BannerInfo;
import com.ax.bean.TeacherRecommendInfo;
import com.ax.dao.banner.BannerInfoDao;
import com.ax.dao.user.TeacherRecommendInfoDao;
import com.ax.exception.DaoException;
import com.ax.service.sys.IndexService;

@Service("indexServiceImpl")



public class IndexServiceImpl implements IndexService{
	
	@Resource
	private BannerInfoDao bannerInfoDao;
	@Resource
	TeacherRecommendInfoDao teacherRecommendInfo;
	/**
	 * 构建首页信息
	 */
	@Override
	public String goIndex(int num,float width,float height) {
		int state = 200;
		String msg = "success";
		List<TeacherRecommendInfo> teachers = getTeacherInfo();
		List<BannerInfo> banners = getBannerInfo(3,width,height);
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray a2 = new JSONArray();
		for(int i=0;i<banners.size();i++){
			BannerInfo banner = banners.get(i);
			array.add(banner);
		}
		for(int j=0;j<teachers.size();j++){
			TeacherRecommendInfo th = teachers.get(j);
			a2.add(th);
		}
		obj.put("state", state);
		obj.put("msg", msg);
		obj.put("pictures", array);
		obj.put("teachers", a2);
		return obj.toString();
	}
	
	/**
	 * 获取要在首页推荐的名师的信息
	 * @return
	 */
	
	@Override
	public List<TeacherRecommendInfo> getTeacherInfo(){
		List<TeacherRecommendInfo> result = null;
		//这里从数据库读取推荐的名师信息,现在构建的是假数据来模拟这个业务逻辑
		try {
			result = teacherRecommendInfo.findByHQL("from TeacherRecommendInfo", null);
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	@Override
	public List<BannerInfo> getBannerInfo(int num,float width,float height){
		List<BannerInfo> find = null;
		List<BannerInfo> result = new ArrayList<BannerInfo>();
		find = bannerInfoDao.findByNum(num);
		for(int i=0;i<find.size();i++){
			BannerInfo bannerinfo = find.get(i);
			String pic = bannerinfo.getPic();
			//System.out.println(pic+"?width="+width+"&height="+height+"&fileName="+bannerinfo.getFileName());
			//BannerInfo banner = new BannerInfo();
			bannerinfo.setPic(pic+"?width="+width+"&height="+height+"&fileName="+bannerinfo.getFileName());
			result.add(bannerinfo);
		}
		return result;
	}
}
