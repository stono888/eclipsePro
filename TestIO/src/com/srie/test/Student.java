package com.srie.test;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

	private String stuno;
	private String stuname;
	// 该元素不会进行jvm默认的序列化，也可以自己完成这个元素的序列化；
	private transient int stuage;
	private transient int age2;

	public Student(String stuno, String stuname, int stuage, int age2) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.stuage = stuage;
		this.age2 = age2;
	}

	public int getAge2() {
		return age2;
	}

	public void setAge2(int age2) {
		this.age2 = age2;
	}

	public Student() {
	}

	public Student(String stuno, String stuname, int stuage) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.stuage = stuage;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public int getStuage() {
		return stuage;
	}

	public void setStuage(int stuage) {
		this.stuage = stuage;
	}

	@Override
	public String toString() {
		return "Student [stuno=" + stuno + ", stuname=" + stuname + ", stuage="
				+ stuage + ", age2=" + age2 + "]";
	}

	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException {
		s.defaultWriteObject();// 把jvm能默认序列化的元素进行序列化操作；
		s.writeInt(stuage);// 自己完成stuage的序列化；
		// 如果是其他元素，可以用writeObject()
		s.writeInt(age2);
	}

	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();// 把jvm能默认反序列化元素进行反序列化操作；
		this.age2 = s.readInt();// 按照相反的顺序进行读取，看看有什么效果？
		/**
		 * 如果按照相反的顺序进行读取，就会把stuage和age2互换了；
		 */
		this.stuage = s.readInt();// 自己完成stuage的反序列化操作；

	}
}
