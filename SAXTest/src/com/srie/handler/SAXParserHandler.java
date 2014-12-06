package com.srie.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	int bookIndex = 0;

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
			bookIndex++;
			System.out.println("===========��ʼ������" + bookIndex
					+ "���������==========");
			// //��֪bookԪ�������Ե����ƣ������������ƻ�ȡ����ֵ
			// String value = attributes.getValue("id");
			// System.out.println("book������ֵ�ǣ�"+value);
			// ��֪��bookԪ�������Ե����ƣ���λ�ȡ������������ֵ��
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
				System.out.print("bookԪ�صĵ�" + (i + 1) + "���������ǣ�"
						+ attributes.getQName(i));
				System.out.println("---����ֵ�ǣ�" + attributes.getValue(i));
			}
		} else if (!qName.equals("book") && !qName.equals("bookstore")) {
			System.out.print("�ڵ����ǣ�" + qName);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		String value = new String(ch, start, length);
		if (!value.trim().equals("")) {
			System.out.println("---�ڵ�ֵ�ǣ�"+value);
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
			System.out.println("========����������" + bookIndex + "���������=========");
		}
	}

	/**
	 * ������ʶ������ʼ
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX������ʼ");
	}

	/**
	 * ������ʶ��������
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX��������");
	}
}
