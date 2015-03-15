/*
 * Title:        爱学圈服务器 2015年2月2日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月2日
 */
package com.ax.service.school.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ax.bean.School;
import com.ax.dao.school.SchoolDao;
import com.ax.exception.DaoException;
import com.ax.service.school.SchoolService;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月2日
 */
@Service
public class SchoolServiceImpl implements SchoolService{
	
	@Resource
	private SchoolDao schoolDao;
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.school.SchoolService#getAll()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @return
	 * @throws DaoException 
	 */
	@Override
	public List<School> getAll() throws DaoException {
		return schoolDao.findAll();
	}

}
