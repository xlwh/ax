/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
public class SchoolInfoUtil {
	public static void main(String[]args){
		String url = "http://data.api.gkcx.eol.cn/soudaxue/recommendListController.html?messtype=jsonp&keyWord1=&province=%E6%B1%9F%E8%8B%8F&schooltype=&schoolprop=&pagesign=queryschool&schoolflag=&zycengci=&zytype=&page=1&size=10&year3=&luqutype3=&luqupici3=&callback=jQuery171007969659500664761_1422764304185&_=1422764320702";
		try {
			System.out.println(URLDecoder.decode(url, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
