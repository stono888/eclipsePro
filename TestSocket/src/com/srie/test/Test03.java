package com.srie.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ʹ��URL��ȡҳ������
 * 
 * @author ThinkPad
 *
 */
public class Test03 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://10.1.191.97");
			url = new URL("http://www.baidu.com");
			//��ȡ�ֽ�������
			InputStream is = url.openStream();
			//���ֽ�������ת��Ϊ�ַ�������
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//Ϊ����ӻ��壬��߶�ȡЧ��
			BufferedReader bf = new BufferedReader(isr);
			//��ȡ���ݣ�
			String data = bf.readLine();
			while(data !=null){
				System.out.println(data);
				data = bf.readLine();
			}
			bf.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
