package com.ax.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Tomcat容器启动监听器
 *    用于在Tomcat容器启动的时候自动读取服务器环境配置
 *    自动填写好服务器的一些配置文件
 * @author Administrator
 *
 */
public class ConfigInit implements ServletContextListener{
	@SuppressWarnings("unused")
	private String name = "config.properties";
	private Properties properties;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("服务器容器销毁");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("服务器容器已经启动了");
		File f=new File(File.separator);
		System.out.println(f.getAbsolutePath());
		File file = new File("/etc/pic");
		System.out.println(file.getPath());
		if(file.exists() == false){
			file.mkdir();
		}
		InputStream in = this.getClass().getResourceAsStream("/config.properties");
	
		properties = new Properties();
		try {
			properties.load(in);
			properties.setProperty("imageDir", file.getAbsolutePath());
			System.out.println(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
