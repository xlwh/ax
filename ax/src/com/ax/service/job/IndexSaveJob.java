/*
 * Title:        爱学圈服务器 2015年1月26日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月26日
 */
package com.ax.service.job;

import javax.annotation.Resource;

import com.ax.dao.course.CourseDao;

/**
 * 数据库自动索引
 * 每天晚上凌晨两点，自动执行数据库的索引建立任务
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月26日
 */
public class IndexSaveJob {
	@Resource
	private CourseDao courseDao;
	public void saveIndex(){
		try {
			courseDao.createIndexByHibernateSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
