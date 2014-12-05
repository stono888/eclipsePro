package com.srie.test;

import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {

	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			File srcFile = new File("e:/software/1.exe");
			File destFile = new File("e:/software/11.exe");
			// IOUtil.copyFileByByte(srcFile, destFile);//83330
			long end = System.currentTimeMillis();
			System.out.println(end - start);
			// IOUtil.copyFileByBuffer(srcFile, destFile);//52805
			start = System.currentTimeMillis();
			System.out.println(start - end);
			IOUtil.copyFile(srcFile, destFile);// 6148 //5748
			end = System.currentTimeMillis();
			System.out.println(end - start);
			IOUtil.copyFileByBufferAndBytes(srcFile, destFile);//5777
			start = System.currentTimeMillis();
			System.out.println(start - end);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
