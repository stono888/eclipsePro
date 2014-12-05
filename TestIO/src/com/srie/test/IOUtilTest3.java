package com.srie.test;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

	public static void main(String[] args) {
		try {
			IOUtil.copyFile(new File("e:/software/1.exe"), new File(
					"e:/software/11.exe"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
