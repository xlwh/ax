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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * (一句话功能简述)
 * 爱学圈动态信息的图片的实体bean
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月9日
 */
@Entity
@Table(name = "T_CIRCLEIMAGE")
public class CircleImage implements Serializable {
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private float size;
	private String fileName;
	private float width;
	private float heigh;
	private String path;
	private String fileType;

	public CircleImage() {
		super();
	}

	public CircleImage(String id, float size, String fileName, float width, float heigh, String path, String fileType) {
		super();
		this.id = id;
		this.size = size;
		this.fileName = fileName;
		this.width = width;
		this.heigh = heigh;
		this.path = path;
		this.fileType = fileType;
	}
	
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CIRCLEIMAGE_ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name="CIRCLE_SIZE")
	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}
	@Column(name="CIRCLEIMAGE_FILENAME",length = 20)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Column(name="CIRCLEIMAGE_WIDTH")
	public float getWidth() {
		return width;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	@Column(name="CIRCLEIMAGE_HEIGH")
	public float getHeigh() {
		return heigh;
	}

	public void setHeigh(float heigh) {
		this.heigh = heigh;
	}
	@Column(name="CIRCLEIMAGE_PATH",length = 50)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	@Column(name="CIRCLEIMAGE_FILETYPE",length = 12)
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + Float.floatToIntBits(heigh);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + Float.floatToIntBits(size);
		result = prime * result + Float.floatToIntBits(width);
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
		CircleImage other = (CircleImage) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (Float.floatToIntBits(heigh) != Float.floatToIntBits(other.heigh))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (Float.floatToIntBits(size) != Float.floatToIntBits(other.size))
			return false;
		if (Float.floatToIntBits(width) != Float.floatToIntBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CircleImage [id=" + id + ", size=" + size + ", fileName=" + fileName + ", width=" + width + ", heigh="
				+ heigh + ", path=" + path + ", fileType=" + fileType + "]";
	}

}
