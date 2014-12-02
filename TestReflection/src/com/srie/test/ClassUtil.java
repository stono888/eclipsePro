package com.srie.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

	/**
	 * print class message, including methods, parameters
	 * 
	 * @param obj
	 */
	public static void printClassMethodMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("Class name:" + c.getName());
		/*
		 * Method类，方法对象 getMethods()获得所有public的函数，包括父类继承而来的
		 * getDeclaredMethods()获得所有该类自己的方法，不问访问权限
		 */
		Method[] ms = c.getMethods();// c.getDeclaredMethods();
		for (int i = 0; i < ms.length; i++) {
			// 方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			// 方法的名称
			System.out.print(ms[i].getName() + "(");
			// 获取参数类型--->得到的是参数列表的类型的类类型
			Class[] paramType = ms[i].getParameterTypes();
			for (Class class1 : paramType) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");

		}
	}

	/**
	 * 获取成员变量信息
	 * 
	 * @param obj
	 */
	public static void printClassFieldMethd(Object obj) {
		/*
		 * 成员变量也是对象 java.lang.reflect.Field Field类封装了关于成员变量的操作
		 */
		// Field[] fs = c.getFields();
		Class c = obj.getClass();
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName);
		}
	}

	/**
	 * 打印对象构造函数的信息
	 * 
	 * @param obj
	 */
	public static void printConMessage(Object obj) {
		Class c = obj.getClass();
		// 构造函数也是对象
		// java.lang.Constructor中封装了构造函数的信息
		// Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName() + "(");
			//获取构造函数参数列表
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
}
