package com.srie.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.srie.entity.Book;
import com.srie.handler.SAXParserHandler;

public class SAXTest {

	public static void main(String[] args) {
		SAXTest saxTest = new SAXTest();
		// saxTest.parseXML();
		saxTest.createXML();
	}

	public void createXML() {
		ArrayList<Book> bookList = parseXML();
		// ����xml
		// 1.����һ��SAXTransformerFactory��Ķ���
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		try {
			// 2.ͨ��SAXTransformerFactory���󴴽�һ��TransformerHandler����
			TransformerHandler handler = tff.newTransformerHandler();
			// 3.ͨ��handler���󴴽�һ��Transformer����
			Transformer tr = handler.getTransformer();
			// 4.ͨ��Transformer��������ɵ�xml�ļ���������
			// ����xml�ı���
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			// ����xml�Ƿ���
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			// 5.����һ��result����
			File f = new File("src/res/newbooks.xml");
			if (!f.exists()) {
				f.createNewFile();
			}
			Result result = new StreamResult(new FileOutputStream(f));
			// 6.����һ��result���󣬲���ʹ����handler������
			handler.setResult(result);
			// 7.����handler�������xml�ļ����ݵı�д
			// ��document
			handler.startDocument();
			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", "bookStore", attr);
			for (Book book : bookList) {
				attr.clear();
				attr.addAttribute("", "", "id", "", book.getId());
				handler.startElement("", "", "book", attr);
				// ����name�ڵ�
				if (book.getName() != null && !book.getName().trim().equals("")) {
					attr.clear();
					handler.startElement("", "", "name", attr);
					handler.characters(book.getName().toCharArray(), 0, book
							.getName().toCharArray().length);
					handler.endElement("", "", "name");
				}
				// ����year�ڵ�
				if (book.getYear() != null && !book.getYear().trim().equals("")) {
					attr.clear();
					handler.startElement("", "", "year", attr);
					handler.characters(book.getYear().toCharArray(), 0, book
							.getYear().toCharArray().length);
					handler.endElement("", "", "year");
				}
				// ����author�ڵ�
				if (book.getAuthor() != null
						&& !book.getAuthor().trim().equals("")) {
					attr.clear();
					handler.startElement("", "", "author", attr);
					handler.characters(book.getAuthor().toCharArray(), 0, book
							.getAuthor().toCharArray().length);
					handler.endElement("", "", "author");
				}
				// ����price�ڵ�
				if (book.getPrice() != null
						&& !book.getPrice().trim().equals("")) {
					attr.clear();
					handler.startElement("", "", "price", attr);
					handler.characters(book.getPrice().toCharArray(), 0, book
							.getPrice().toCharArray().length);
					handler.endElement("", "", "price");
				}
				// ����language�ڵ�
				if (book.getLanguage() != null
						&& !book.getLanguage().trim().equals("")) {
					attr.clear();
					handler.startElement("", "", "language", attr);
					handler.characters(book.getLanguage().toCharArray(), 0,
							book.getLanguage().toCharArray().length);
					handler.endElement("", "", "language");
				}

				handler.endElement("", "", "book");

			}
			handler.endElement("", "", "bookStore");
			// �ر�document
			handler.endDocument();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Book> parseXML() {
		// ��ȡһ��SAXParserFactory��ʵ��
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParserHandler handler = null;
		// ͨ��factory��ȡSAXParserʵ��
		try {
			SAXParser parser = factory.newSAXParser();
			// ����һ��SAXParserHandler����
			handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
			System.out
					.println("~!~!~!����" + handler.getBookList().size() + "����");
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
		return handler.getBookList();
	}

}
