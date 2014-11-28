package com.srie.test;

/**
 * @author ThinkPad
 * 任何一个类是java.lang.Class的实例对象；
 * 这个实例有三种表达方式；
 * 每种方式称为Foo类的类类型（class type）;
 * 必须有无参构造函数才可以用newInstance()方法才可以创建实例；
 *
 */
public class TestFoo {

	public static void main(String[] args) {
		Foo foo = new Foo("a");
		Class class1 = Foo.class;
		Class class2 = foo.getClass();
		Class class3 = null;
		try {
			class3 = Class.forName("com.srie.test.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(class1==class2);
		System.out.println(class2==class3);
		try {
			Foo foo2 = (Foo)class3.newInstance();
			foo2.print();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
class Foo{
	public Foo(){
		System.out.println("asdf");
	}
	public Foo(String a){
		System.out.println("asdf:"+a);
	}
	void print(){
		System.out.println("Foo");
	}
}