package com.srie.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public DocumentBuilder getDocumentBuilder() {
		// ����һ��DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// ����һ��DocumentBuilder����
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return db;
	}

	public void xmlParser() {
		try {
			// ͨ��DocumentBuilder�����parse��������books.xml�ļ�����ǰ��Ŀ��
			Document document = getDocumentBuilder().parse("books.xml");
			// ��ȡ����book�ڵ�ļ���
			NodeList bookList = document.getElementsByTagName("book");
			// ͨ��nodelist��getLength()�������Ի��bookList�ĳ���
			System.out.println("һ����" + bookList.getLength() + "����");
			// ����ÿһ��book�ڵ�
			for (int i = 0; i < bookList.getLength(); i++) {
				System.out.println("==============���濪ʼ������" + (i + 1)
						+ "���������===================");
				// ͨ��bookList.getItem(i)��ȡһ��book�ڵ㣬nodeList������ֵ��0��ʼ
				Node book = bookList.item(i);
				// ��ȡbook�ڵ���������Լ���
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("��" + (i + 1) + "���鹲��" + attrs.getLength()
						+ "������");
				// ����book������
				for (int j = 0; j < attrs.getLength(); j++) {
					// ͨ��item(index)������ȡbook�ڵ��ĳһ������
					Node attr = attrs.item(j);
					// ��ȡ������
					attr.getNodeName();
					System.out.print("��������" + attr.getNodeName());
					// ��ȡ����ֵ
					attr.getNodeValue();
					System.out.println("--����ֵ��" + attr.getNodeValue());
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
				System.out.println("��" + (i + 1) + "���鹲��"
						+ childNodes.getLength() + "���ӽڵ�");
				for (int k = 0; k < childNodes.getLength(); k++) {
					// ����text���͵�node��element���͵�node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// ��ȡ��element���ͽڵ�Ľڵ���
						System.out.print("��" + (k + 1) + "���ڵ�Ľڵ����ǣ�"
								+ childNodes.item(k).getNodeName());
						// System.out.println(childNodes.item(k).getNodeValue());
						// �����element���ͽڵ�Ľڵ�ֵ
						System.out.println("--�ڵ�ֵ�ǣ�"
								+ childNodes.item(k).getFirstChild()
										.getNodeValue());
						// System.out.println("--�ڵ�ֵ�ǣ�"
						// + childNodes.item(k).getTextContent());
					}
				}

				System.out.println("==============����������" + (i + 1)
						+ "���������===================");
			}

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����XML
	 */
	public void createXML() {
		DocumentBuilder db = getDocumentBuilder();
		Document document = db.newDocument();
		document.setXmlStandalone(true);
		Element bookStore = document.createElement("bookStore");
		// ��bookStore���ڵ�������ӽڵ�book
		Element book = document.createElement("book");
		book.setAttribute("id", "1");
		Element name = document.createElement("name");
		// name.setNodeValue("С����");
		name.setTextContent("С����");
		Element author = document.createElement("author");
		author.setTextContent("������");
		Element price = document.createElement("price");
		price.setTextContent("98");
		Element year = document.createElement("year");
		year.setTextContent("2006");
		book.appendChild(author);
		book.appendChild(name);
		book.appendChild(price);
		book.appendChild(year);
		// ��book�ڵ���ӵ�bookStore��
		bookStore.appendChild(book);
		// ��bookStore�ڵ㣨�Ѿ�������book����ӵ�dom����
		document.appendChild(bookStore);

		// ����TransformerFactory����
		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			// ����Transformer����
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document), new StreamResult(new File(
					"books1.xml")));

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// ����DOMTest����
		DOMTest test = new DOMTest();
		// ���ý�������������XML�ļ�
		// test.xmlParser();
		test.createXML();

	}

}
