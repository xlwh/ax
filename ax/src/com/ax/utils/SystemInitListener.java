/*
 * Title:        爱学圈服务器 2015年1月28日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月28日
 */
package com.ax.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ax.exception.DaoException;

/**
 *服务器初始化监听器，执行服务器的一些初始化部署的任务
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月28日
 */

public class SystemInitListener implements ServletContextListener{
	private CreateView createView = new CreateView();
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @param arg0
	 */
	@Override
	public void contextDestroyed(ServletContextEvent env) {
		
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @param arg0
	 */
	@Override
	public void contextInitialized(ServletContextEvent env) {
		createView();
		
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 创建视图
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	public void createView(){
		try {
			createView.create();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
