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
		// 创建一个DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建一个DocumentBuilder对象
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
			// 通过DocumentBuilder对象的parse方法加载books.xml文件到当前项目下
			Document document = getDocumentBuilder().parse("books.xml");
			// 获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			// 通过nodelist的getLength()方法可以获得bookList的长度
			System.out.println("一共有" + bookList.getLength() + "本书");
			// 遍历每一个book节点
			for (int i = 0; i < bookList.getLength(); i++) {
				System.out.println("==============下面开始遍历第" + (i + 1)
						+ "本书的内容===================");
				// 通过bookList.getItem(i)获取一个book节点，nodeList的索引值从0开始
				Node book = bookList.item(i);
				// 获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength()
						+ "个属性");
				// 遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					// 通过item(index)方法获取book节点的某一个属性
					Node attr = attrs.item(j);
					// 获取属性名
					attr.getNodeName();
					System.out.print("属性名：" + attr.getNodeName());
					// 获取属性值
					attr.getNodeValue();
					System.out.println("--属性值：" + attr.getNodeValue());
				}
				// // 前提：book节点有且仅能有一个id属性
				// // 将book节点进行强制类型转换，转换成element
				// Element book = (Element) bookList.item(i);
				// // 通过getAttribute("id")方法获取属性值
				// String attrValue = book.getAttribute("id");
				// System.out.println("id属性的属性值为" + attrValue);
				// 解析book节点的子节点
				NodeList childNodes = book.getChildNodes();
				// 遍历childNodes获得每个节点的节点名和节点值
				System.out.println("第" + (i + 1) + "本书共有"
						+ childNodes.getLength() + "个子节点");
				for (int k = 0; k < childNodes.getLength(); k++) {
					// 区分text类型的node和element类型的node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// 获取了element类型节点的节点名
						System.out.print("第" + (k + 1) + "个节点的节点名是："
								+ childNodes.item(k).getNodeName());
						// System.out.println(childNodes.item(k).getNodeValue());
						// 获得了element类型节点的节点值
						System.out.println("--节点值是："
								+ childNodes.item(k).getFirstChild()
										.getNodeValue());
						// System.out.println("--节点值是："
						// + childNodes.item(k).getTextContent());
					}
				}

				System.out.println("==============结束遍历第" + (i + 1)
						+ "本书的内容===================");
			}

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成XML
	 */
	public void createXML() {
		DocumentBuilder db = getDocumentBuilder();
		Document document = db.newDocument();
		document.setXmlStandalone(true);
		Element bookStore = document.createElement("bookStore");
		// 向bookStore根节点中添加子节点book
		Element book = document.createElement("book");
		book.setAttribute("id", "1");
		Element name = document.createElement("name");
		// name.setNodeValue("小王子");
		name.setTextContent("小王子");
		Element author = document.createElement("author");
		author.setTextContent("乔治马丁");
		Element price = document.createElement("price");
		price.setTextContent("98");
		Element year = document.createElement("year");
		year.setTextContent("2006");
		book.appendChild(author);
		book.appendChild(name);
		book.appendChild(price);
		book.appendChild(year);
		// 将book节点添加到bookStore中
		bookStore.appendChild(book);
		// 将bookStore节点（已经包含了book）添加到dom树中
		document.appendChild(bookStore);

		// 创建TransformerFactory对象
		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			// 创建Transformer对象
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
		// 创建DOMTest对象
		DOMTest test = new DOMTest();
		// 调用解析方法，解析XML文件
		// test.xmlParser();
		test.createXML();

	}

}
