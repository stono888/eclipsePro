package com.srie.test;

import java.io.File;
import java.io.IOException;

/**
 * 列出file类的一些常用操作，比如过滤、遍历等
 * 
 * @author ThinkPad
 *
 */
public class FileUtils {
	/**
	 * 递归列出目录下的所有文件
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException {
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录" + dir + "不存在.");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "不是目录.");
		}
		// String[] filenames = dir.list();//返回的是字符串数组，子的名称，不包含下一级；
		// for (String string : filenames) {
		// System.out.println(dir+File.separator+string);
		// }
		/*
		 * 如果需要遍历子目录下的内容，就需要构造成file对象，做递归；file提供了直接返回file对象的api；
		 */
		File[] files = dir.listFiles();// 返回的是直接子目录的抽象；
		// for (File file : files) {
		// System.out.println(file);
		// if(file.isDirectory()){
		// listDirectory(file);
		// }
		// }
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					listDirectory(file);
				} else {
					System.out.println(file);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
