package com.srie.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.srie.entity.Book;

public class JDOMTest {

	private static ArrayList<Book> booksList = new ArrayList<Book>();

	public static void main(String[] args) {
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
			Document document = saxBuilder.build(isr);
			// 4.通过document对象获得xml文件的根节点
			Element rootElement = document.getRootElement();
			// 5.获取根节点下的子节点的List集合
			List<Element> bookList = rootElement.getChildren();
			// 继续进行解析
			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("=====开始解析第" + (bookList.indexOf(book) + 1)
						+ "本书=====");
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
					System.out.println("属性名：" + attrName + "---属性值："
							+ attrValue);
					if (attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				// 对book节点的子节点的节点名和节点值进行遍历
				List<Element> bookChildren = book.getChildren();
				for (Element child : bookChildren) {
					System.out.println("节点名：" + child.getName() + "\t---节点值："
							+ child.getValue());
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

				System.out.println("=====结束解析第" + (bookList.indexOf(book) + 1)
						+ "本书=====");
				booksList.add(bookEntity);
				bookEntity = null;
				System.out.println(booksList.size());
				System.out.println(booksList.get(0));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
