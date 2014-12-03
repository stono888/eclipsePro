package com.srie.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServerThread extends Thread {
	DatagramSocket socket = null;
	DatagramPacket packet = null;
	byte[] data = null;

	public UDPServerThread(DatagramSocket socket, DatagramPacket packet,
			byte[] data) {
		this.socket = socket;
		this.packet = packet;
		this.data = data;
	}

	@Override
	public void run() {
		try {
			// 4����ȡ�ͻ�������
			String info = new String(data, 0, packet.getLength());
			System.out.println("���Ƿ��������ͻ���˵��" + info);
			/**
			 * ��ͻ�����Ӧ����
			 */
			// 1������ͻ��˵ĵ�ַ���˿ںš�����
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			byte[] data2 = "��ӭ����".getBytes();
			// 2���������ݰ���������Ӧ��������Ϣ��
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length,
					address, port);
			// 3,��Ӧ�ͻ���
			socket.send(packet2);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
