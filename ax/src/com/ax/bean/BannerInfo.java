package com.ax.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="T_BANNERINFO")
@Component
public class BannerInfo {
	private int id;
	private String pic;
	private String title;
	private int type;
	private String detail;
	private String fileName;
	
	public BannerInfo() {
		super();
		
	}
	
	
	
	public BannerInfo(int id, String pic, String title, int type, String detail) {
		super();
		this.id = id;
		this.pic = pic;
		this.title = title;
		this.type = type;
		this.detail = detail;
	}



	@Id
	@GeneratedValue
	@Column(name="BANNERINFO_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="BANNERINFO_PIC",length = 150)
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@Column(name="BANNERINFO_TITLE",length = 30)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="BANNERINFO_TYPE")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Column(name="BANNERINFO_DETAIL",length = 3000)
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name="BANNERINFO_FILENAME",length=20)
   public String getFileName() {
		return fileName;
	}

   public void setFileName(String fileName) {
		this.fileName = fileName;
	}

    
	
}
