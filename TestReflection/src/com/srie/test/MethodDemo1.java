package com.srie.test;

import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		A a = new A();
		Class c = a.getClass();
		try {
			// Method m = c.getMethod("print", new
			// Class[]{int.class,int.class});
			// Method m = c.getMethod("print", int.class, int.class);
			Method m = c.getDeclaredMethod("print", int.class, int.class);
			// a.print(10, 20);
			Object o = m.invoke(a, 10, 20);
			System.out.println(o);
			System.out.println("========================");
			Method m1 = c.getMethod("print", String.class, String.class);
			m1.invoke(a, "hello", "World");
			System.out.println("========================");
			// Method m2 = c.getMethod("print", new Class[]{});
			Method m2 = c.getMethod("print");
			// m2.invoke(a, null);
			m2.invoke(a);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class A {
	public void print() {
		System.out.println("hello world");
	}

	public void print(int a, int b) {
		System.out.println(a + b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + "," + b.toLowerCase());
	}
}