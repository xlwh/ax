package com.ax.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ax.bean.BannerInfo;
import com.ax.exception.DaoException;
import com.ax.utils.ConfigReader;
import com.ax.web.service.user.BannerInfoService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("struts-default")
@Namespace("/web")
public class BannerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private BannerInfoService bannerInfoService;
	@Resource
	private ConfigReader configReader;
	//标题
	private String title;
	//类型
	private String type;
	//内容
	private String content;
	//上传的图片
	private File image;
	// 封装上传文件类型的属性
	private String imageContentType;
	// 封装上传文件名的属性
	private String imageFileName;
	// 接受依赖注入的属性
	private String savePath;
	private String info;
	
	  @Action(value="save",results={
			   @Result(name="success",location="/manager/main.jsp"),
		       @Result(name="input",location="index.jsp")	   
	   })
	public String save() {

		try {
			savaBannerInfo();
			FileOutputStream fos = null;
			FileInputStream fis = null;
			try {
				// 建立文件输出流
				System.out.println(getSavePath());
				System.out.println("文件保存：" + configReader.getImageDir() + "\\" + getImageFileName());
				fos = new FileOutputStream(configReader.getImageDir() + "\\" + getImageFileName());
				// 建立文件上传流
				fis = new FileInputStream(getImage());
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

			} catch (Exception e) {
				System.out.println("文件上传失败");
				e.printStackTrace();
			} finally {
				close(fos, fis);
			}

		} catch (DaoException e) {
			//信息保存失败
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	private void savaBannerInfo() throws DaoException {
		BannerInfo banner = new BannerInfo();
		banner.setDetail(getContent());
		banner.setFileName(getImageFileName());
		banner.setPic("http:/study211.duapp.com/img/download");
		banner.setType(0);
		bannerInfoService.save(banner);
	}

	/**
	 * 关闭流
	 * @param fos
	 * @param fis
	 */
	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("FileInputStream关闭失败");
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("FileOutputStream关闭失败");
				e.printStackTrace();
			}
		}
	}

}
