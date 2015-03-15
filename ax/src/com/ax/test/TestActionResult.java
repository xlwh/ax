/*
 * Title:        爱学圈服务器 2015年1月28日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月28日
 */
package com.ax.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ax.action.ActionResult;
import com.ax.bean.Users;
import com.ax.exception.ConvertJosnException;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月28日
 */
public class TestActionResult {
	//@Test
	public void testToJson1(){
		ActionResult action = new ActionResult(null,null);
		String ks[] = {"name","age","school"};
		Map<String,Object> kvs = new HashMap<String,Object>();
		kvs.put("name", "张洪斌");
		kvs.put("age", 22);
		kvs.put("school", "南京邮电大学");
		try {
			System.out.println(action.toJson(ks, kvs));
		} catch (ConvertJosnException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJson2(){
		ActionResult action = new ActionResult(null,null);
		List<Object> obj = new ArrayList<Object>(); 
		for(int i=0;i<10;i++){
			Users user = new Users();
			user.setName("张洪斌");
			obj.add(user);
		}
		System.out.println(action.toJson(obj));
	}
}
