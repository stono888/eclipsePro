package com.srie.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("e:/software/autf8.txt");
		FileWriter fw = new FileWriter("e:/software/a11.txt");
		// FileWriter fw = new FileWriter("e:/software/a11.txt",true);//×·¼ÓÄÚÈÝ
		char[] buffer = new char[2056];
		int c;
		while ((c = fr.read(buffer, 0, buffer.length)) != -1) {
			fw.write(buffer, 0, c);
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
