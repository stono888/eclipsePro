package com.srie.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ���Socketͨ�ţ���������
 * 
 * @author ThinkPad
 *
 */
public class Server {

	public static void main(String[] args) {
		try {
			// ����serverSocket��ָ���˿ڣ������м���
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			// ��¼�ͻ��˵�����
			int count = 0;
			System.out.println("***�����������������ȴ��ͻ�������***");
			// ѭ�������ͻ��˵�����
			while (true) {
				// ����accept()��������ʼ����
				socket = serverSocket.accept();
				// ����һ���̣߳���֮ͨ��
				ServerThread serverThread = new ServerThread(socket);
				serverThread.setPriority(4);// �����߳����ȼ�����Χ[1��10]��Ĭ��Ϊ5
				// �����߳�
				serverThread.start();
				count++;
				System.out.println("�ͻ�����������" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�ͻ���Ip��" + address.getHostAddress());
			}
			// serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
