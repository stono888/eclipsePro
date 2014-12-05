package com.srie.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {

	public static void main(String[] args) throws IOException {
		File demo = new File("demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}

		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// 指针的位置
		System.out.println(raf.getFilePointer());
		raf.write('A');// 只写了一个字节
		System.out.println(raf.getFilePointer());
		raf.write('B');
		int i = 0x7fffffff;
		// 用write方法，每次只能写一个字节，要把i写进入，需要写四次；
		raf.write(i >>> 24);// 高八位；
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		System.out.println(raf.getFilePointer());
		// 可以直接写一个int
		raf.writeInt(i);
		System.out.println(raf.length());
		String s = "中";
		byte[] gbk = s.getBytes("gbk");
		raf.write(gbk);
		System.out.println(raf.length());
		// 读文件，必须把指针移到头部
		raf.seek(0);
		// 一次性读取,把文件中的内容都读到字节数组中；
		byte[] buf = new byte[(int) raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		/**
		 * 这样包装也是没用的，因为“中”是java字符串，是utf-16be编码；其前后还有一些别的字节； 除非只把那块字节拿出来；
		 */
		// String s1 = new String(buf,"gbk");
		// System.out.println(s1);
		// byte [] buf2 = new byte[2];
		// buf2[0]=buf[10];
		// buf2[1]= buf[11];
		// String s2 = new String(buf2,"gbk");
		// System.out.println(s2);
		for (byte b : buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		raf.close();
	}

}
