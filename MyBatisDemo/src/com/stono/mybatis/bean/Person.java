package com.stono.mybatis.bean;

import java.util.Date;

/**
 * Person类对象
 *
 */
public class Person {

	// Person 主键
	private Integer id;
	// 名称
	private String name;
	// 备注1
	private String content1;
	// 日期时间
	private Date time1;
	// 部门id
	private Integer d_id;

	public Person() {
	}

	public Person(String name, String content1, Date time1, Integer d_id) {
		this.name = name;
		this.content1 = content1;
		this.time1 = time1;
		this.d_id = d_id;
	}

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

	public Integer getD_id() {
		return d_id;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", content1=" + content1
				+ ", time1=" + time1 + ", d_id=" + d_id + "]";
	}

}
