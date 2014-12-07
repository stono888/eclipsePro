package com.srie.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.srie.entity.Book;
import com.srie.handler.SAXParserHandler;

public class SAXTest {

	public static void main(String[] args) {
		// ��ȡһ��SAXParserFactory��ʵ��
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//ͨ��factory��ȡSAXParserʵ��
		try {
			SAXParser parser = factory.newSAXParser();
			//����һ��SAXParserHandler����
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
			System.out.println("~!~!~!����"+handler.getBookList().size()+"����");
			for (Book book : handler.getBookList()) {
				System.out.println(book);
				System.out.println(book.getId());
				System.out.println(book.getName());
				System.out.println(book.getAuthor());
				System.out.println(book.getYear());
				System.out.println(book.getPrice());
				System.out.println(book.getLanguage());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
