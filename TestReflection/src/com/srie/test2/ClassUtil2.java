package com.srie.test2;

import java.lang.reflect.Method;

public class ClassUtil2 {

	public static void printClassMethod(Object object) {
		Class c = object.getClass();
		Method[] ms = c.getMethods();
		for (Method method : ms) {
			System.out.print(method.getModifiers()+" ");
			Class class1 = method.getReturnType();
			System.out.print(class1.getName() + " ");
			System.out.print(method.getName() + "(");
			Class[] ps = method.getParameterTypes();
			for (Class class2 : ps) {
				System.out.print(class2.getName() + ",");
			}
			System.out.println(")");
		}
	}

	public static void printClassDeclaredMethod(Object object) {
		Class c = object.getClass();
		Method[] ms = c.getDeclaredMethods();
		for (Method method : ms) {
			System.out.print(method.getModifiers()+" ");
			Class class1 = method.getReturnType();
			System.out.print(class1.getName() + " ");
			System.out.print(method.getName() + "(");
			Class[] ps = method.getParameterTypes();
			for (Class class2 : ps) {
				System.out.print(class2.getName() + ",");
			}
			System.out.println(")");
		}
	}
}
