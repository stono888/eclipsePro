package com.srie.test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL
 * 
 * @author ThinkPad
 *
 */
public class Test02 {

	public static void main(String[] args) {
		try {
			URL imooc = new URL("http://www.imooc.com");
			// #�����ʾê��
			URL url = new URL(imooc, "/index.html?username=tom#test");
			System.out.println("Э�飺" + url.getProtocol());
			System.out.println("������" + url.getHost());
			System.out.println("�˿�:" + url.getPort());
			System.out.println("�ļ�·����"+url.getPath());
			System.out.println("�ļ����ƣ�"+url.getFile());
			System.out.println("���·����"+url.getRef());
			System.out.println("��ѯ�ַ���:"+url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
