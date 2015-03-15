/*
 * Title:        爱学圈服务器 2015年1月22日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月22日
 */
package com.ax.test;

import org.junit.Test;

import com.ax.exception.ActionException;
import com.ax.exception.ExceptionHandle;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月22日
 */
public class TestBaseException {
	
	public void testBaseException(){
		ExceptionHandle.throwException(new Exception("测试错误"), "com.ax.test.TestException#testBaseException()");
	}
	@Test
	public void testActionException(){
		ExceptionHandle.throwException(new ActionException("action执行错误"), "com.ax.test.TestException#testBaseException()");
	}
}
