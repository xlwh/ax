/*
 * Title:        爱学圈服务器 2015年1月26日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月26日
 */
package com.ax.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月26日
 */
public class TestQuartz implements Job{

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 调度作业的执行
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param arg0
	 * @throws JobExecutionException
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("作业被调度.....");
		
	}
	
}
