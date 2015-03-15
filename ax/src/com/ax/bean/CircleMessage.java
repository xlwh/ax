/*
 * Title:        爱学圈服务器 2015年3月9日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年3月9日
 */
package com.ax.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * (一句话功能简述)
 * 学习圈动态信息实体bean
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月9日
 */
@Entity
@Table(name = "T_CIRCLEMESSAGE")
public class CircleMessage implements Serializable {
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int uid;
	private String content;
	private Set<CircleImage> images = new HashSet<CircleImage>();
	private Date createTime;
	private Set<CircleCommonent> commonents = new HashSet<CircleCommonent>();
	private int visited;
	private int praised;
	private float lng;
	private float lat;

	public CircleMessage() {
		super();
	}

	public CircleMessage(String id, int uid, String content, Set<CircleImage> images, Date createTime,
			Set<CircleCommonent> commonents, int visited, int praised, float lng, float lat) {
		super();
		this.id = id;
		this.uid = uid;
		this.content = content;
		this.images = images;
		this.createTime = createTime;
		this.commonents = commonents;
		this.visited = visited;
		this.praised = praised;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CIRCLEMESSAGE_ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "CIRCLEMESSAGE_UID")
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Column(name = "CIRCLEMESSAGE_CONTENT", length = 2000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CIRCLEMESSAGE_IMAGES")
	public Set<CircleImage> getImages() {
		return images;
	}

	public void setImages(Set<CircleImage> images) {
		this.images = images;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CIRCLEMESSAGE_CREATETIME", length = 19, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CIRCLEMESSAGE_COMMONENT")
	public Set<CircleCommonent> getCommonents() {
		return commonents;
	}

	public void setCommonents(Set<CircleCommonent> commonents) {
		this.commonents = commonents;
	}

	@Column(name = "CIRCLEMESSAGE_VISITED")
	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}

	@Column(name = "CIRCLEMESSAGE_PRAISED")
	public int getPraised() {
		return praised;
	}

	public void setPraised(int praised) {
		this.praised = praised;
	}
	@Column(name="CIRCLEMESSAGE_LNG")
	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}
	@Column(name="CIRCLEMESSAGE_LAT")
	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "CircleMessage [id=" + id + ", uid=" + uid + ", content=" + content + ", images=" + images
				+ ", createTime=" + createTime + ", commonents=" + commonents + ", visited=" + visited + ", praised="
				+ praised + ", lng=" + lng + ", lat=" + lat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commonents == null) ? 0 : commonents.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + Float.floatToIntBits(lat);
		result = prime * result + Float.floatToIntBits(lng);
		result = prime * result + praised;
		result = prime * result + uid;
		result = prime * result + visited;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CircleMessage other = (CircleMessage) obj;
		if (commonents == null) {
			if (other.commonents != null)
				return false;
		} else if (!commonents.equals(other.commonents))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat))
			return false;
		if (Float.floatToIntBits(lng) != Float.floatToIntBits(other.lng))
			return false;
		if (praised != other.praised)
			return false;
		if (uid != other.uid)
			return false;
		if (visited != other.visited)
			return false;
		return true;
	}

}
