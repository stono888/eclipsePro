package com.srie.test;

public class RadixMain {

	public static void main(String[] args) {
		// 十进制转为其它进制
		System.out.println(Integer.toBinaryString(112));// 二进制
		System.out.println(Integer.toHexString(112));// 十六进制
		System.out.println(Integer.toOctalString(112));// 八进制

		// 其它进制转化为十进制
		System.out.println(Integer.parseInt("111001", 2));// 二进制
		System.out.println(Integer.parseInt("27", 8));// 八进制
		System.out.println(Integer.parseInt("A8", 16));// 十六进制
		System.out.println(Integer.parseInt("12", 3));// 三进制
	}

}
