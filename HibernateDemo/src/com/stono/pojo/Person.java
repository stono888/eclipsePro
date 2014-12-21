package com.stono.pojo;

import java.util.Date;

/**
 * �־û������<br>
 * ע�⣺<br>
 * �־û���ͨ��������һ���־û���ʶ��<br>
 * �־û���ʶ��ͨ������ʹ�÷�װ�ࣨ����������Ĭ��ֵ��<br>
 * �־û���ͨ�������ֶ�����һ���޲ι���������Ϊ��Щ�������Ƿ�����еģ�<br>
 * ����ͨ�������ṩgetter/setter����<br>
 * �־û��಻����final�ģ�finalû�����ࣻ<br>
 * �־û��������ʹ���˼����������ݣ�ֻ��ʹ�ýӿ����ͽ���������List/Set/Map��<br>
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
