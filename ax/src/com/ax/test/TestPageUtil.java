/*
 * Title:        爱学圈服务器 2015年1月22日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月22日
 */
package com.ax.test;

import com.ax.bean.Page;
import com.ax.bean.Users;
import com.ax.utils.PageUtil;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月22日
 */
public class TestPageUtil {
	
	public void testLastPage(){
		PageUtil<Users> util = new PageUtil<Users>();
		Page<Users> page = util.newPage(10, 100);
		//输出第一页的信息
		System.out.println("===============第1页====================");
		System.out.println(page.toString());
		
		//从第一页翻上一页
		System.out.println("===============上一页====================");
		Page<Users> last = util.lastPage(page);
		if(last !=null){
			System.out.println(last.toString());
		}else{
			System.out.println("没有上一页");
		}
	    
		//下一页
		System.out.println("===============下2页====================");
		Page<Users> next = util.nextPage(page);
		if( next != null){
			System.out.println(next.toString());
		}else{
			System.out.println("没有下一页");
		}
		
		System.out.println("===============3页====================");
		Page<Users> next3 = util.nextPage(next);
		if( next3 != null){
			System.out.println(next3.toString());
		}else{
			System.out.println("没有下一页");
		}
		
		System.out.println("===============下4页====================");
		Page<Users> next4 = util.nextPage(next3);
		if( next4 != null){
			System.out.println(next4.toString());
		}else{
			System.out.println("没有下一页");
		}
		
		System.out.println("===============5页====================");
		Page<Users> next5 = util.nextPage(next4);
		if( next5 != null){
			System.out.println(next5.toString());
		}else{
			System.out.println("没有下一页");
		}
		
		System.out.println("===============6页====================");
		Page<Users> next6 = util.nextPage(next5);
		if( next6 != null){
			System.out.println(next6.toString());
		}else{
			System.out.println("没有下一页");
		}
		
		System.out.println("===============7页====================");
		Page<Users> next7 = util.nextPage(next6);
		if( next7 != null){
			System.out.println(next7.toString());
		}else{
			System.out.println("没有下一页");
		}
		
		System.out.println("===============8页====================");
		Page<Users> next8 = util.nextPage(next7);
		if( next8 != null){
			System.out.println(next8.toString());
		}else{
			System.out.println("没有下一页");
		}
		
		System.out.println("===============9页====================");
		Page<Users> next9 = util.nextPage(next8);
		if( next9 != null){
			System.out.println(next9.toString());
		}else{
			System.out.println("没有下一页");
		}
		
		System.out.println("===============10页====================");
		Page<Users> next10 = util.nextPage(next9);
		if( next10 != null){
			System.out.println(next10.toString());
		}else{
			System.out.println("没有下一页");
		}
		
		System.out.println("===============11页====================");
		Page<Users> next11 = util.nextPage(next10);
		if( next11 != null){
			System.out.println(next11.toString());
		}else{
			System.out.println("没有下一页");
		}
		
	}
	
	public static void main(String[]args){
		new TestPageUtil().testLastPage();
	}
}
