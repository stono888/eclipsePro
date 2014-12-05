package com.srie.test;

import java.io.IOException;

public class IOUtilTest2 {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
//		IOUtil.printHexByByteArray("e:\\software\\a.txt");
//		IOUtil.printHex("e:\\software\\1.exe");
		IOUtil.printHexByByteArray("e:\\software\\1.exe");
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println(end - start);
	}

}
