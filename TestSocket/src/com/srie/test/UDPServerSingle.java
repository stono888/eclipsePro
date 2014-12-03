package com.srie.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * TODO 1�����߳����ȼ� 2���Ƿ�ر���������� 3��ʹ��TCP���ݶ��� 4��ʹ��TCP�����ļ� 5,UDP�ж��߳̽���;
 * �������ˣ�ʵ�ֻ���UDP���û���֤
 * 
 * @author ThinkPad
 *
 */
public class UDPServerSingle {

	public static void main(String[] args) {
		try {
			/**
			 * �������˽��տͻ��˵���Ϣ
			 */
			// 1��������������DatagramSocket��ָ���˿ں�
			DatagramSocket socket = new DatagramSocket(8800);
			// 2���������ݰ����洢�ͻ��˷��͵����ݣ�
			byte[] data = new byte[1024];// �����ֽ����飬ָ������
			DatagramPacket packet = new DatagramPacket(data, data.length);
			// 3�����տͻ��˷��͵����ݣ�
			System.out.println("***���������Ѿ��������ȴ��ͻ��˷�������***");
			socket.receive(packet);// �˷����ڽ��յ����ݰ�֮ǰ��һֱ������
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
			// 4,�ر���Ӧ����Դ��Ϣ
			socket.close();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
