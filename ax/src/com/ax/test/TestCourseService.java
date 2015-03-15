/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.test;

import org.junit.Test;

import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;
import com.ax.service.course.CourseService;


/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
public class TestCourseService extends BaseTest{
	
	//@Test
	public void testTimeConvert(){
		String format = "2015-08-03";
		String year = format.substring(0, 4);
		String mounth = format.substring(5, 7);
		String day = format.substring(8, 10);
		System.out.println(year+","+mounth+","+day);
		
	}
	
	public  boolean checkTimeFormat(String time){
		boolean result = false;
		int i=0,j=0,k=0,l=0,m=0;
		if(time.length() == 10){
			char s[] = time.toCharArray();
			for(char c:s){
				m++;
				if(c == '-'){
					++l;
					System.out.println(l);
				}
				switch(l){
				case 1:{i=m;};break;
				case 2:{j=m;};break;
				case 3:{k=m;};break;
				}
			}
			System.out.println(i+","+j+","+k);
			if(i==7 && j==10 && k==0){
				result = true;
				System.out.println(i+","+j+","+k);
			}
			
		}else{
			result = false;
		}
		return result;
	}
	
	@Test
	public void setUp(){
		CourseService service = (CourseService)ctx.getBean("courseServiceImpl");
		try {
			service.getSubjects();
		} catch (NullPointException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
