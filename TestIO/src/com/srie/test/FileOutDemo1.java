package com.srie.test;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {

	public static void main(String[] args) throws IOException {
		// 如果该文件不存在，则直接创建；如果存在，删除后创建；
		FileOutputStream out = new FileOutputStream("demo/out.dat");
		/*
		 * // 如果存在，就会追加内容； FileOutputStream out1 = new
		 * FileOutputStream("demo/out.dat",true);
		 */
		out.write('A');// 写出了'A'字符的低八位；
		out.write('B');// 写出了'B'字符的低八位；
		int a = 10;// write只能写八位，写一个int需要写四次；每次八位；
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		byte[] gbk = "中国".getBytes("gbk");
		out.write(gbk);
		out.close();
		
		IOUtil.printHex("demo/out.dat");

	}

}
