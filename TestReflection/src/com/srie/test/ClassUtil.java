package com.srie.test;

import java.lang.reflect.Method;

public class ClassUtil {

	/**
	 * print class message, including methods, parameters
	 * 
	 * @param obj
	 */
	public static void printClassMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("Class name:" + c.getName());
		/*
		 * Method类，方法对象
		 * getMethods()获得所有public的函数，包括父类继承而来的
		 * getDeclaredMethods()获得所有该类自己的方法，不问访问权限
		 */
		Method [] ms = c.getMethods();//c.getDeclaredMethods();
		for(int i=0;i<ms.length;i++){
			//方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			//方法的名称
			System.out.print(ms[i].getName()+"(");
			//获取参数类型--->得到的是参数列表的类型的类类型
			Class[] paramType = ms[i].getParameterTypes();
			for (Class class1 : paramType) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
	}
}
