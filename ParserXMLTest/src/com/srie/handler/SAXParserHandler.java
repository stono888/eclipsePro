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
	 * ��������xml�ļ��еĿ�ʼ��ǩ
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// ����DefaultHandler���startElement����
		super.startElement(uri, localName, qName, attributes);
		// ��ʼ����bookԪ�ص�����
		if (qName.equals("book")) {
			book = new Book();
			bookIndex++;
//			System.out.println("===========��ʼ������" + bookIndex
//					+ "���������==========");
			// //��֪bookԪ�������Ե����ƣ������������ƻ�ȡ����ֵ
			// String value = attributes.getValue("id");
			// System.out.println("book������ֵ�ǣ�"+value);
			// ��֪��bookԪ�������Ե����ƣ���λ�ȡ������������ֵ��
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
//				System.out.print("bookԪ�صĵ�" + (i + 1) + "���������ǣ�"
//						+ attributes.getQName(i));
//				System.out.println("---����ֵ�ǣ�" + attributes.getValue(i));
				if (attributes.getQName(i).equals("id")) {
					book.setId(attributes.getValue(i));
				}
			}
		} else if (!qName.equals("book") && !qName.equals("bookstore")) {
//			System.out.print("�ڵ����ǣ�" + qName);
		}
		// qName.equals("name")ʱ����book������setName
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if (!value.trim().equals("")) {
//			System.out.println("---�ڵ�ֵ�ǣ�" + value);
		}
	}

	/**
	 * ��������xml�ļ��еĽ�����ǩ
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// ����DefaultHandler�۵�endElement����
		super.endElement(uri, localName, qName);
		// �ж��Ƿ����һ�����Ѿ���������
		if (qName.equals("book")) {
			//����book��ǩ��ʱ�򣬽�����գ�
			bookList.add(book);
			book = null;
//			System.out.println("========����������" + bookIndex + "���������=========");
		} else if (qName.equals("name")) {
			// �Ƚ���startElement��Ȼ�����characters��Ȼ����endElement����
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
	 * ������ʶ������ʼ
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
//		System.out.println("SAX������ʼ");
	}

	/**
	 * ������ʶ��������
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
//		System.out.println("SAX��������");
	}
}
