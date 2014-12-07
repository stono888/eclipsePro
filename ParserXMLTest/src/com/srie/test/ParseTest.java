package com.srie.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Attribute;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.srie.entity.Book;
import com.srie.handler.SAXParserHandler;

public class ParseTest {

	public static void main(String[] args) {

	}

	public void domXmlParser() {

		// ����һ��DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// ����һ��DocumentBuilder����
		try {
			// ����һ��DocumentBuilder����
			DocumentBuilder db = dbf.newDocumentBuilder();
			// ͨ��DocumentBuilder�����parse��������books.xml�ļ�����ǰ��Ŀ��
			Document document = db.parse("books.xml");
			// ��ȡ����book�ڵ�ļ���
			NodeList bookList = document.getElementsByTagName("book");
			// ͨ��nodelist��getLength()�������Ի��bookList�ĳ���
			System.out.println("һ����" + bookList.getLength() + "����");
			// ����ÿһ��book�ڵ�
			for (int i = 0; i < bookList.getLength(); i++) {
				// System.out.println("==============���濪ʼ������" + (i + 1)
				// + "���������===================");
				// ͨ��bookList.getItem(i)��ȡһ��book�ڵ㣬nodeList������ֵ��0��ʼ
				Node book = bookList.item(i);
				// ��ȡbook�ڵ���������Լ���
				NamedNodeMap attrs = book.getAttributes();
				// System.out.println("��" + (i + 1) + "���鹲��" + attrs.getLength()
				// + "������");
				// ����book������
				for (int j = 0; j < attrs.getLength(); j++) {
					// ͨ��item(index)������ȡbook�ڵ��ĳһ������
					Node attr = attrs.item(j);
					// ��ȡ������
					attr.getNodeName();
					// System.out.print("��������" + attr.getNodeName());
					// ��ȡ����ֵ
					attr.getNodeValue();
					// System.out.println("--����ֵ��" + attr.getNodeValue());
				}
				// // ǰ�᣺book�ڵ����ҽ�����һ��id����
				// // ��book�ڵ����ǿ������ת����ת����element
				// Element book = (Element) bookList.item(i);
				// // ͨ��getAttribute("id")������ȡ����ֵ
				// String attrValue = book.getAttribute("id");
				// System.out.println("id���Ե�����ֵΪ" + attrValue);
				// ����book�ڵ���ӽڵ�
				NodeList childNodes = book.getChildNodes();
				// ����childNodes���ÿ���ڵ�Ľڵ����ͽڵ�ֵ
				// System.out.println("��" + (i + 1) + "���鹲��"
				// + childNodes.getLength() + "���ӽڵ�");
				for (int k = 0; k < childNodes.getLength(); k++) {
					// ����text���͵�node��element���͵�node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// ��ȡ��element���ͽڵ�Ľڵ���
						// System.out.print("��" + (k + 1) + "���ڵ�Ľڵ����ǣ�"
						// + childNodes.item(k).getNodeName());
						// System.out.println(childNodes.item(k).getNodeValue());
						// �����element���ͽڵ�Ľڵ�ֵ
						// System.out.println("--�ڵ�ֵ�ǣ�"
						// + childNodes.item(k).getFirstChild()
						// .getNodeValue());
						// System.out.println("--�ڵ�ֵ�ǣ�"
						// + childNodes.item(k).getTextContent());
					}
				}

				// System.out.println("==============����������" + (i + 1)
				// + "���������===================");
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saxXmlParser() {

		// ��ȡһ��SAXParserFactory��ʵ��
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// ͨ��factory��ȡSAXParserʵ��
		try {
			SAXParser parser = factory.newSAXParser();
			// ����һ��SAXParserHandler����
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
			// System.out
			// .println("~!~!~!����" + handler.getBookList().size() + "����");
			for (Book book : handler.getBookList()) {
				// System.out.println(book);
				// System.out.println(book.getId());
				// System.out.println(book.getName());
				// System.out.println(book.getAuthor());
				// System.out.println(book.getYear());
				// System.out.println(book.getPrice());
				// System.out.println(book.getLanguage());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void jdomXmlParser() {

		// ��books.xml�ļ���JDOM����
		// ׼������
		// 1.����һ��SAXBuilder����
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream in;
		try {
			// 2.����һ������������XML�ļ����ص�������������
			in = new FileInputStream("src/res/books.xml");
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			// 3.ͨ��saxBuilder��build�����������������ص�saxBuilder�У�
			org.jdom2.Document document = saxBuilder.build(isr);
			// 4.ͨ��document������xml�ļ��ĸ��ڵ�
			Element rootElement = document.getRootElement();
			// 5.��ȡ���ڵ��µ��ӽڵ��List����
			List<Element> bookList = rootElement.getChildren();
			// �������н���
			for (Element book : bookList) {
				Book bookEntity = new Book();
				// System.out.println("=====��ʼ������" + (bookList.indexOf(book) +
				// 1)
				// + "����=====");
				// //֪���ڵ�����������ʱ����ȡ�ڵ�����ֵ
				// book.getAttributeValue("id");
				// ����book�����Լ���
				List<Attribute> attrList = book.getAttributes();
				// ����attrList(��Բ����book�ڵ������Ե����ּ�����)
				for (Attribute attr : attrList) {
					// ��ȡ������
					String attrName = attr.getName();
					// ��ȡ����ֵ
					String attrValue = attr.getValue();
					// System.out.println("��������" + attrName + "---����ֵ��"
					// + attrValue);
					if (attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				// ��book�ڵ���ӽڵ�Ľڵ����ͽڵ�ֵ���б���
				List<Element> bookChildren = book.getChildren();
				for (Element child : bookChildren) {
					// System.out.println("�ڵ�����" + child.getName() + "\t---�ڵ�ֵ��"
					// + child.getValue());
					if (child.getName().equals("name")) {
						bookEntity.setName(child.getValue());
					} else if (child.getName().equals("author")) {
						bookEntity.setAuthor(child.getValue());
					} else if (child.getName().equals("year")) {
						bookEntity.setYear(child.getValue());
					} else if (child.getName().equals("price")) {
						bookEntity.setPrice(child.getValue());
					} else if (child.getName().equals("language")) {
						bookEntity.setLanguage(child.getValue());
					}
				}

				// System.out.println("=====����������" + (bookList.indexOf(book) +
				// 1)
				// + "����=====");
				bookEntity = null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void dom4jXmlParser() {

		// ����books.xml�ļ�
		// ����SAXReader����reader
		SAXReader reader = new SAXReader();
		try {
			// ͨ��reader�����read��������books.xml�ļ�,��ȡdocument����
			org.dom4j.Document document = reader.read(new File(
					"src/res/books.xml"));
			// ͨ��document�����ȡ���ڵ�bookStore
			org.dom4j.Element bookStore = document.getRootElement();
			// ͨ��element�����elementIterator������õ�����
			Iterator it = bookStore.elementIterator();
			// ��������������ȡ���ڵ��е���Ϣ
			while (it.hasNext()) {
//				System.out.println("======��ʼ����ĳһ����======");
				org.dom4j.Element book = (org.dom4j.Element) it.next();
				// ��ȡbook���������Լ�����ֵ
				List<org.dom4j.Attribute> bookAttrs = book.attributes();
				for (org.dom4j.Attribute attr : bookAttrs) {
					// System.out.println("��������" + attr.getName() + "---����ֵ��"
					// + attr.getValue());

				}
				Iterator itt = book.elementIterator();
				while (itt.hasNext()) {
					org.dom4j.Element bookChild = (org.dom4j.Element) itt
							.next();
					// System.out.println("�ڵ�����" + bookChild.getName() +
					// "---�ڵ�ֵ��"
					// + bookChild.getStringValue());
				}
				// System.out.println("======�������� ĳһ����======");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testPerformance() {
		System.out.println("���ܲ���");
		// ����DOM�����ܣ�
		long start = System.currentTimeMillis();
		domXmlParser();
		System.out.println("DOM:" + (System.currentTimeMillis() - start));
		// ����SAX�����ܣ�
		start = System.currentTimeMillis();
		saxXmlParser();
		System.out.println("SAX:" + (System.currentTimeMillis() - start));
		// ����JDOM�����ܣ�
		start = System.currentTimeMillis();
		jdomXmlParser();
		System.out.println("JDOM:" + (System.currentTimeMillis() - start));
		// ����DOM4J�����ܣ�
		start = System.currentTimeMillis();
		dom4jXmlParser();
		System.out.println("DOM4J:" + (System.currentTimeMillis() - start));
	}

}
