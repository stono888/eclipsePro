package com.srie.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDOMTest {

	public static void main(String[] args) {
		// 对books.xml文件的JDOM解析
		// 准备工作
		// 1.创建一个SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream in;
		try {
			// 2.创建一个输入流，将XML文件加载到输入流中来；
			in = new FileInputStream("src/res/books.xml");
			// 3.通过saxBuilder的build方法，将输入流加载到saxBuilder中；
			Document document = saxBuilder.build(in);
			// 4.通过document对象获得xml文件的根节点
			Element rootElement = document.getRootElement();
			// 5.获取根节点下的子节点的List集合
			List<Element> bookList = rootElement.getChildren();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
