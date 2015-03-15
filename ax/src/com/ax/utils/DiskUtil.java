package com.ax.utils;

import java.io.File;

import org.junit.Test;

/**
 * 服务器磁盘工具
 * @author Administrator
 *
 */
public class DiskUtil {
	
	@Test
	public void getPath(){
		File f=new File(File.separator);
		System.out.println(f.getAbsolutePath());
	}
	
	
	
}
