package com.dw.party.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * POJO Study
 * @author xingkong1221
 *
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 426967801139238594L;
	
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", nullable = false, length = 10)
	private long id;
	
	@Column(name = "user_id", nullable = true, length = 200)
	private String createUserId;
	
	@Column(name = "username", nullable = true, length = 200)
	private String username;
	
	@NotEmpty(message = "标题不能为空")
	@Column(name = "title", nullable = false, length = 200)
	private String title;
	
	@NotEmpty(message = "学习内容描述不能为空")
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "organ_id", nullable = true, length = 200)
	private String organId;

	@NotNull
	@Column(name = "start_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	
	@NotNull
	@Column(name = "end_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "create_time")
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
