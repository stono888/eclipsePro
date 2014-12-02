package com.srie.test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo4 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("asdf");
		Class c1 = list.getClass();
		Class c2 = list1.getClass();
		System.out.println(c1==c2);
		/**
		 * c1==c2说明java编译之后是去泛型话的；
		 * 只在编译阶段有效，防止输入错误；
		 * 验证：通过反射进行验证；
		 */
		try {
			Method m = c2.getMethod("add",Object.class);
			m.invoke(list1, 20);
			System.out.println(list1.size());
			System.out.println(list1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
}
