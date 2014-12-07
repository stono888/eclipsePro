package com.srie.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.srie.entity.Book;

public class SAXParserHandler extends DefaultHandler {
	int bookIndex = 0;
	private String value = null;
	private Book book = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();


	public ArrayList<Book> getBookList() {
		return bookList;
	}

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
			book = new Book();
			bookIndex++;
//			System.out.println("===========开始遍历第" + bookIndex
//					+ "本书的内容==========");
			// //已知book元素下属性的名称，根据属性名称获取属性值
			// String value = attributes.getValue("id");
			// System.out.println("book的属性值是："+value);
			// 不知道book元素下属性的名称，如何获取属性名和属性值？
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
//				System.out.print("book元素的第" + (i + 1) + "个属性名是："
//						+ attributes.getQName(i));
//				System.out.println("---属性值是：" + attributes.getValue(i));
				if (attributes.getQName(i).equals("id")) {
					book.setId(attributes.getValue(i));
				}
			}
		} else if (!qName.equals("book") && !qName.equals("bookstore")) {
//			System.out.print("节点名是：" + qName);
		}
		// qName.equals("name")时，向book对象中setName
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if (!value.trim().equals("")) {
//			System.out.println("---节点值是：" + value);
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
			//结束book标签的时候，进行清空；
			bookList.add(book);
			book = null;
//			System.out.println("========结束遍历第" + bookIndex + "本书的内容=========");
		} else if (qName.equals("name")) {
			// 先进行startElement，然后进行characters，然后到了endElement方法
			book.setName(value);
			/*
			 * //use reflection Class c = Book.class; Method[] ms =
			 * c.getMethods(); for (Method method : ms) { if
			 * (method.getName().toUpperCase() .equals("SET" +
			 * qName.toUpperCase())) { try { method.invoke(book, value); } catch
			 * (IllegalArgumentException e) { e.printStackTrace(); } catch
			 * (IllegalAccessException e) { e.printStackTrace(); } catch
			 * (InvocationTargetException e) { e.printStackTrace(); } } }
			 */
		} else if (qName.equals("author")) {
			book.setAuthor(value);
		} else if (qName.equals("year")) {
			book.setYear(value);
		} else if (qName.equals("price")) {
			book.setPrice(value);
		} else if (qName.equals("language")) {
			book.setLanguage(value);
		}
	}

	/**
	 * 用来标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
//		System.out.println("SAX解析开始");
	}

	/**
	 * 用来标识解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
//		System.out.println("SAX解析结束");
	}
}
