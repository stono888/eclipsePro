package com.srie.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * TODO 1�����߳����ȼ� 2���Ƿ�ر���������� 3��ʹ��TCP���ݶ��� 4��ʹ��TCP�����ļ� 5,UDP�ж��߳̽���;
 * �������ˣ�ʵ�ֻ���UDP���û���֤
 * 
 * @author ThinkPad
 *
 */
public class UDPServer {

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
			int count = 0;
			while (true) {
				socket.receive(packet);// �˷����ڽ��յ����ݰ�֮ǰ��һֱ������
				UDPServerThread thread = new UDPServerThread(socket, packet,
						data);
				thread.start();
				count++;
				System.out.println("�ͻ�����������" + count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
