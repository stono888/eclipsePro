package com.srie.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		/**
		 * ��������˷�������
		 */
		// 1,�����������ַ��
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "�û���:tom;����:123".getBytes();
		// 2,�������ݰ���������ص���Ϣ��
		DatagramPacket packet = new DatagramPacket(data, data.length, address,
				port);
		// 3,����DatagramSocket����
		DatagramSocket socket = new DatagramSocket();
		// 4,��������˷������ݱ���
		socket.send(packet);
		/**
		 * ���շ���������Ӧ
		 */
		// 1���������ݰ������շ�����������
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		// 2,���շ�����������
		socket.receive(packet2);
		// 3,��ȡ����
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("���ǿͻ��ˣ�������˵��" + reply);
		// 4,�ر���Դ
		socket.close();
	}

}
