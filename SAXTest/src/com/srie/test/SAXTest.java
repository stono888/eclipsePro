package com.srie.test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXTest {

	public static void main(String[] args) {
		// 获取一个SAXParserFactory的实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//通过factory获取SAXParser实例
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(uri, dh);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

}
