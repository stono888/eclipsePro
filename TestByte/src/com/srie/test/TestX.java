package com.srie.test;

/**
 * 进行数字交换；<br/>
 * a = 01;<br/>
 * b = 10;<br/>
 * a = a ^ b ---> a = 11, b = 10;<br/>
 * b = b ^ a ---> b = 01, a = 11;<br/>
 * a = a ^ b ---> a = 10, b = 01;<br/>
 * 
 * @author ThinkPad
 *
 */
public class TestX {

	public static void main(String[] args) {
		/*
		 * a 与 b互换；
		 */
		int a = 1;
		int b = 10;
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println("a:" + a + ";b:" + b);
		int c = -14;
		int d = c << 2;
		System.out.println(d);
		/*
		 * 最大整数求法；
		 */
		int e = -1;
		int f = e >>> 1;
		System.out.println(f);
		System.out.println(0x7fffffff);
		System.out.println(-1 >>> 1);
		System.out.println(~14);
		/*
		 * 求平均值
		 */
		int i1 = 100;
		int i2 = 200;
		System.out.println((i1 & i2) + ((i1 ^ i2) >> 1));

	}

}
