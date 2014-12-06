package com.srie.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	int bookIndex = 0;

	/**
	 * 用来遍历xml文件中的开始标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// 调用DefaultHandler类的startElement方法
		super.startElement(uri, localName, qName, attributes);
		// 开始解析book元素的属性
		if (qName.equals("book")) {
			bookIndex++;
			System.out.println("===========开始遍历第" + bookIndex
					+ "本书的内容==========");
			// //已知book元素下属性的名称，根据属性名称获取属性值
			// String value = attributes.getValue("id");
			// System.out.println("book的属性值是："+value);
			// 不知道book元素下属性的名称，如何获取属性名和属性值？
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
				System.out.print("book元素的第" + (i + 1) + "个属性名是："
						+ attributes.getQName(i));
				System.out.println("---属性值是：" + attributes.getValue(i));
			}
		}else if(!qName.equals("book") && !qName.equals("bookstore")){
			System.out.println("节点名是：" + qName);
		}
	}

	/**
	 * 用来遍历xml文件中的结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// 调用DefaultHandler累的endElement方法
		super.endElement(uri, localName, qName);
		// 判断是否针对一本书已经遍历结束
		if (qName.equals("book")) {
			System.out.println("========结束遍历第" + bookIndex + "本书的内容=========");
		}
	}

	/**
	 * 用来标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX解析开始");
	}

	/**
	 * 用来标识解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX解析结束");
	}
}
