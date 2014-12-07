package com.srie.test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JTest {

	public static void main(String[] args) {
		// ����books.xml�ļ�
		// ����SAXReader����reader
		SAXReader reader = new SAXReader();
		try {
			// ͨ��reader�����read��������books.xml�ļ�,��ȡdocument����
			Document document = reader.read(new File("src/res/books.xml"));
			// ͨ��document�����ȡ���ڵ�bookStore
			Element bookStore = document.getRootElement();
			// ͨ��element�����elementIterator������õ�����
			Iterator it = bookStore.elementIterator();
			// ��������������ȡ���ڵ��е���Ϣ
			while (it.hasNext()) {
				System.out.println("======��ʼ����ĳһ����======");
				Element book = (Element) it.next();
				// ��ȡbook���������Լ�����ֵ
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("��������" + attr.getName() + "---����ֵ��"
							+ attr.getValue());

				}
				Iterator itt = book.elementIterator();
				while (itt.hasNext()) {
					Element bookChild = (Element) itt.next();
					System.out.println("�ڵ�����" + bookChild.getName() + "---�ڵ�ֵ��"
							+ bookChild.getStringValue());
				}
				System.out.println("======�������� ĳһ����======");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
