package com.stono.mybatis.bean;

import java.util.Date;

/**
 * 部门类
 */
public class Department {

	// 部门主键
	private Integer id;
	// 部门名称
	private String name;
	// 部门内容
	private String content1;
	// 日期时间
	private Date time1;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public Date getTime1() {
		return time1;
	}

	public void setTime1(Date time1) {
		this.time1 = time1;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", content1="
				+ content1 + ", time1=" + time1 + "]";
	}

}
