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
		 * Method�࣬�������� getMethods()�������public�ĺ�������������̳ж�����
		 * getDeclaredMethods()������и����Լ��ķ��������ʷ���Ȩ��
		 */
		Method[] ms = c.getMethods();// c.getDeclaredMethods();
		for (int i = 0; i < ms.length; i++) {
			// �����ķ���ֵ���͵�������
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			// ����������
			System.out.print(ms[i].getName() + "(");
			// ��ȡ��������--->�õ����ǲ����б�����͵�������
			Class[] paramType = ms[i].getParameterTypes();
			for (Class class1 : paramType) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");

		}
	}

	/**
	 * ��ȡ��Ա������Ϣ
	 * 
	 * @param obj
	 */
	public static void printClassFieldMethd(Object obj) {
		/*
		 * ��Ա����Ҳ�Ƕ��� java.lang.reflect.Field Field���װ�˹��ڳ�Ա�����Ĳ���
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
	 * ��ӡ�����캯������Ϣ
	 * 
	 * @param obj
	 */
	public static void printConMessage(Object obj) {
		Class c = obj.getClass();
		// ���캯��Ҳ�Ƕ���
		// java.lang.Constructor�з�װ�˹��캯������Ϣ
		// Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName() + "(");
			//��ȡ���캯�������б�
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
}
