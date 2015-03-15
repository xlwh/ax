/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.service.commonent.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ax.action.commonent.CommonentResult;
import com.ax.bean.Commonent;
import com.ax.bean.Users;
import com.ax.dao.comment.CommentDao;
import com.ax.dao.user.UserDao;
import com.ax.exception.DaoException;
import com.ax.service.commonent.CommonentService;
import com.ax.utils.DateUtil;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
@Service
public class CommonentServiceImpl implements CommonentService{
	 @Resource
	 private UserDao userDao;
	 @Resource
	 private CommentDao commentDao;
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.commonent.CommonentService#findByTid(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @param tid
	 * @return
	 * @throws DaoException 
	 */
	@Override
	public List<CommonentResult> findByTid(int tid,int page) throws DaoException {
		List<CommonentResult> res = new ArrayList<CommonentResult>();
		List<Commonent> commonents = commentDao.findByUidAndPage(tid, page);
		if(commonents != null && commonents.size()>0){
			for(Commonent cmt : commonents){
				Users user = userDao.findById(cmt.getUserid());
				CommonentResult crst = new CommonentResult();
				crst.setContent(cmt.getDesc());
				Date date = cmt.getCreateTime();
				String tm = DateUtil.format(date);
				crst.setCreateTime(tm);
				crst.setLevel(cmt.getLever());
				crst.setNicname(user.getNicName());
				crst.setPic(user.getPic());
				res.add(crst);
			}
		}else{
			res = null;   //没有相关的评论
		}
		
		return res;
	}
	
	/**
	 * 
	 * 对某个老师发表评论
	 * 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param uid
	 * @param teacherid
	 * @param content
	 * @throws DaoException 
	 */
	public void writeCommonent(int uid,int teacherid,int level,String content) throws DaoException{
		Commonent cmt = new Commonent();
		cmt.setDesc(content);
		cmt.setLever(level);
		cmt.setState(0);  //0是等待审核
		cmt.setTeacherid(teacherid);
		cmt.setType(3);
		commentDao.save(cmt);
	}

}
