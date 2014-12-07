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

		// 创建一个DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建一个DocumentBuilder对象
		try {
			// 创建一个DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parse方法加载books.xml文件到当前项目下
			Document document = db.parse("books.xml");
			// 获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			// 通过nodelist的getLength()方法可以获得bookList的长度
			System.out.println("一共有" + bookList.getLength() + "本书");
			// 遍历每一个book节点
			for (int i = 0; i < bookList.getLength(); i++) {
				// System.out.println("==============下面开始遍历第" + (i + 1)
				// + "本书的内容===================");
				// 通过bookList.getItem(i)获取一个book节点，nodeList的索引值从0开始
				Node book = bookList.item(i);
				// 获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				// System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength()
				// + "个属性");
				// 遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					// 通过item(index)方法获取book节点的某一个属性
					Node attr = attrs.item(j);
					// 获取属性名
					attr.getNodeName();
					// System.out.print("属性名：" + attr.getNodeName());
					// 获取属性值
					attr.getNodeValue();
					// System.out.println("--属性值：" + attr.getNodeValue());
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
				// System.out.println("第" + (i + 1) + "本书共有"
				// + childNodes.getLength() + "个子节点");
				for (int k = 0; k < childNodes.getLength(); k++) {
					// 区分text类型的node和element类型的node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// 获取了element类型节点的节点名
						// System.out.print("第" + (k + 1) + "个节点的节点名是："
						// + childNodes.item(k).getNodeName());
						// System.out.println(childNodes.item(k).getNodeValue());
						// 获得了element类型节点的节点值
						// System.out.println("--节点值是："
						// + childNodes.item(k).getFirstChild()
						// .getNodeValue());
						// System.out.println("--节点值是："
						// + childNodes.item(k).getTextContent());
					}
				}

				// System.out.println("==============结束遍历第" + (i + 1)
				// + "本书的内容===================");
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

		// 获取一个SAXParserFactory的实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 通过factory获取SAXParser实例
		try {
			SAXParser parser = factory.newSAXParser();
			// 创建一个SAXParserHandler对象
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
			// System.out
			// .println("~!~!~!共有" + handler.getBookList().size() + "本书");
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

		// 对books.xml文件的JDOM解析
		// 准备工作
		// 1.创建一个SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream in;
		try {
			// 2.创建一个输入流，将XML文件加载到输入流中来；
			in = new FileInputStream("src/res/books.xml");
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			// 3.通过saxBuilder的build方法，将输入流加载到saxBuilder中；
			org.jdom2.Document document = saxBuilder.build(isr);
			// 4.通过document对象获得xml文件的根节点
			Element rootElement = document.getRootElement();
			// 5.获取根节点下的子节点的List集合
			List<Element> bookList = rootElement.getChildren();
			// 继续进行解析
			for (Element book : bookList) {
				Book bookEntity = new Book();
				// System.out.println("=====开始解析第" + (bookList.indexOf(book) +
				// 1)
				// + "本书=====");
				// //知道节点下属性名称时，获取节点属性值
				// book.getAttributeValue("id");
				// 解析book的属性集合
				List<Attribute> attrList = book.getAttributes();
				// 遍历attrList(针对不清楚book节点下属性的名字及数量)
				for (Attribute attr : attrList) {
					// 获取属性名
					String attrName = attr.getName();
					// 获取属性值
					String attrValue = attr.getValue();
					// System.out.println("属性名：" + attrName + "---属性值："
					// + attrValue);
					if (attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				// 对book节点的子节点的节点名和节点值进行遍历
				List<Element> bookChildren = book.getChildren();
				for (Element child : bookChildren) {
					// System.out.println("节点名：" + child.getName() + "\t---节点值："
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

				// System.out.println("=====结束解析第" + (bookList.indexOf(book) +
				// 1)
				// + "本书=====");
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

		// 解析books.xml文件
		// 创建SAXReader对象reader
		SAXReader reader = new SAXReader();
		try {
			// 通过reader对象的read方法加载books.xml文件,获取document对象
			org.dom4j.Document document = reader.read(new File(
					"src/res/books.xml"));
			// 通过document对象获取根节点bookStore
			org.dom4j.Element bookStore = document.getRootElement();
			// 通过element对象的elementIterator方法获得迭代器
			Iterator it = bookStore.elementIterator();
			// 遍历迭代器，获取根节点中的信息
			while (it.hasNext()) {
//				System.out.println("======开始遍历某一本书======");
				org.dom4j.Element book = (org.dom4j.Element) it.next();
				// 获取book的属性名以及属性值
				List<org.dom4j.Attribute> bookAttrs = book.attributes();
				for (org.dom4j.Attribute attr : bookAttrs) {
					// System.out.println("属性名：" + attr.getName() + "---属性值："
					// + attr.getValue());

				}
				Iterator itt = book.elementIterator();
				while (itt.hasNext()) {
					org.dom4j.Element bookChild = (org.dom4j.Element) itt
							.next();
					// System.out.println("节点名：" + bookChild.getName() +
					// "---节点值："
					// + bookChild.getStringValue());
				}
				// System.out.println("======结束遍历 某一本书======");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testPerformance() {
		System.out.println("性能测试");
		// 测试DOM的性能：
		long start = System.currentTimeMillis();
		domXmlParser();
		System.out.println("DOM:" + (System.currentTimeMillis() - start));
		// 测试SAX的性能：
		start = System.currentTimeMillis();
		saxXmlParser();
		System.out.println("SAX:" + (System.currentTimeMillis() - start));
		// 测试JDOM的性能：
		start = System.currentTimeMillis();
		jdomXmlParser();
		System.out.println("JDOM:" + (System.currentTimeMillis() - start));
		// 测试DOM4J的性能：
		start = System.currentTimeMillis();
		dom4jXmlParser();
		System.out.println("DOM4J:" + (System.currentTimeMillis() - start));
	}

}
