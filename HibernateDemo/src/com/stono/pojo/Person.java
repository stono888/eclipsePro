package com.stono.pojo;

import java.util.Date;

/**
 * 持久化类设计<br>
 * 注意：<br>
 * 持久化类通常建议有一个持久化标识符<br>
 * 持久化标识符通常建议使用封装类（基本类型有默认值）<br>
 * 持久化类通常建议手动给定一个无参构造器（因为有些操作，是反射进行的）<br>
 * 属性通常建议提供getter/setter方法<br>
 * 持久化类不能是final的，final没有子类；<br>
 * 持久化类中如果使用了集合类型数据，只能使用接口类型进行声明（List/Set/Map）<br>
 * List list = new ArrayList();<br>
 * 
 */
public class Person {
	private Integer id;
	private String name;
	private int password;
	private Date birthday;

	public Person() {
	}

	public Person(String name, int password, Date birthday) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", password=" + password
				+ ", birthday=" + birthday + "]";
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

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
