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
		// 生成xml
		// 1.创建一个SAXTransformerFactory类的对象
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		try {
			// 2.通过SAXTransformerFactory对象创建一个TransformerHandler对象
			TransformerHandler handler = tff.newTransformerHandler();
			// 3.通过handler对象创建一个Transformer对象
			Transformer tr = handler.getTransformer();
			// 4.通过Transformer对象对生成的xml文件进行设置
			// 设置xml的编码
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			// 设置xml是否换行
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			// 5.创建一个result对象
			File f = new File("src/res/newbooks.xml");
			if (!f.exists()) {
				f.createNewFile();
			}
			Result result = new StreamResult(new FileOutputStream(f));
			// 6.创建一个result对象，并且使其与handler关联；
			handler.setResult(result);
			// 7.利用handler对象进行xml文件内容的编写
			// 打开document
			handler.startDocument();
			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", "bookStore", attr);
			attr.clear();
			attr.addAttribute("", "", "id", "", "1");
			handler.startElement("", "", "book", attr);
			handler.endElement("", "", "book");
			handler.endElement("", "", "bookStore");
			// 关闭document
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
		// 获取一个SAXParserFactory的实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParserHandler handler = null;
		// 通过factory获取SAXParser实例
		try {
			SAXParser parser = factory.newSAXParser();
			// 创建一个SAXParserHandler对象
			handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
			System.out
					.println("~!~!~!共有" + handler.getBookList().size() + "本书");
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
