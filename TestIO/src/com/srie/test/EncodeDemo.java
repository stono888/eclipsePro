package com.srie.test;

public class EncodeDemo {

	public static void main(String[] args) throws Exception {
		String s = "中文ABCa";
		byte[] bs = s.getBytes();// 转换成字节采用的是项目默认的编码方式
		for (byte b : bs) {
			// 把字节（转换成int）以16进制表示
			System.out.print(Integer.toHexString(b & 0xff) + " ");
			// System.out.println(Integer.toString(b));
		}
		System.out.println();
		byte[] bs2 = s.getBytes("gbk");
		// gbk编码中文占用两个字节，英文占用一个字节；
		for (byte b : bs2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bs3 = s.getBytes("utf-8");
		// utf-8编码中中文占用三个字节，英文占用一个字节；
		for (byte b : bs3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		// java是双字节编码，utf-16be
		byte[] bs4 = s.getBytes("utf-16be");
		// utf-16be中文占用两个字节，英文占用两个字节
		for (byte b : bs4) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		/*
		 * 当你的字节序列是某种编码时，这个时候想把字节序列变成字符串， 也需要使用这种编码方式，否则会出现乱码；
		 */
		String str1 = new String(bs4);// 用项目默认的编码方式；
		System.out.println(str1);
		String str2 = new String(bs4, "utf-16be");
		System.out.println(str2);
		/*
		 * 文本文件 就是字节序列；可以是任意编码的字节序列；如果我们在中文机器上面直接创建文本文件， 该文件只认识ansi编码；
		 * 联通、联这是一种巧合，他们正好符合了utf-8编码的规则；
		 */
		String string = "联";
		byte[] bs5 = string.getBytes();
		for (byte b : bs5) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bs6 = string.getBytes("utf-8");
		for (byte b : bs6) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
	}

}
