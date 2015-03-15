package com.ax.app.action.sys;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 图片处理相关请求处理
 * @author zhanghongbin
 *
 *
 */
@Controller
@ParentPackage("struts-default")
@Namespace("/img")
public class ImageAction extends ActionSupport{
	private float width;
	private float height;
	private String fileName;
	@SuppressWarnings("unused")
	private InputStream DownloadFile;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 实现图片的下载
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	
 public InputStream getDownloadFile() {
		String ps = "D:/etc/pic/"+fileName;
		String path =null;
		try {
			path = URLDecoder.decode(ps, "UTF-8");
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		
		URL url = null;
		try {
			url = new URL(path);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		System.out.println(path);
		Builder bd = Thumbnails.of(url);
		bd.size((int)width, (int)height);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	  try {
			BufferedImage img = bd.asBufferedImage();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ImageIO.write(img, "JPEG", out);
			System.out.println("文件下载");
		 } catch (IOException e) {
			e.printStackTrace();
		}
		ByteArrayInputStream input = new ByteArrayInputStream(out.toByteArray());
		return input;
		
	} 
	
	@Action(value = "download", 
		    results = {
		        @Result(name="success",type="stream",params={"inputName","DownloadFile"}),
		       }
		     )
	public String resize(){
		return SUCCESS;
	}

	
	
	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
