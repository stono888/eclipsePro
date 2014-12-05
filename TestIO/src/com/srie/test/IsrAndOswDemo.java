package com.srie.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream in = new FileInputStream("e:/software/autf8.txt");
			InputStreamReader isr = new InputStreamReader(in,"utf-8");
			
			FileOutputStream out = new FileOutputStream("e:/software/autf81.txt");
			OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
			// 操作的时候，要写文件本身的格式；
			// 默认是按照gbk编码解析的；因为项目默认是gbk编码的；
			// 如果项目是utf-8，就可能出现乱码；
			// InputStreamReader isr = new InputStreamReader(in, "gbk");
			/*
			 * int c; while ((c = isr.read()) != -1) { System.out.print((char)
			 * c); }
			 */
			char[] buff = new char[8 * 1024];
			int c;
			// 批量读取，放入buff字符数组，从第0个位置开始放置，最多放置buff.length个；
			// 返回的是读到的字符的个数
			while ((c = isr.read(buff, 0, buff.length)) != -1) {
				String s = new String(buff, 0, c);
				System.out.print(s);
				osw.write(buff, 0, c);
				osw.flush();
			}
			osw.close();
			isr.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
