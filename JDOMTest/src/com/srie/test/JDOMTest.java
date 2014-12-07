package com.srie.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDOMTest {

	public static void main(String[] args) {
		// ��books.xml�ļ���JDOM����
		// ׼������
		// 1.����һ��SAXBuilder����
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream in;
		try {
			// 2.����һ������������XML�ļ����ص�������������
			in = new FileInputStream("src/res/books.xml");
			// 3.ͨ��saxBuilder��build�����������������ص�saxBuilder�У�
			Document document = saxBuilder.build(in);
			// 4.ͨ��document������xml�ļ��ĸ��ڵ�
			Element rootElement = document.getRootElement();
			// 5.��ȡ���ڵ��µ��ӽڵ��List����
			List<Element> bookList = rootElement.getChildren();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
