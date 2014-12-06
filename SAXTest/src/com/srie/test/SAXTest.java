package com.srie.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.srie.handler.SAXParserHandler;

public class SAXTest {

	public static void main(String[] args) {
		// 获取一个SAXParserFactory的实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//通过factory获取SAXParser实例
		try {
			SAXParser parser = factory.newSAXParser();
			//创建一个SAXParserHandler对象
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
