/*
 * Title:        爱学圈服务器 2015年1月27日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月27日
 */
package com.ax.test;

import org.junit.Test;

import com.ax.utils.DateUtil;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月27日
 */
public class TestDateUtil {
	@Test
	public void testgetTimeByDbFormat(){
		System.out.println(DateUtil.getTimeByDbFormat());
	}
}
