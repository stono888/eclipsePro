package com.srie.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			// 1������serverSocket��ָ���˿ڣ������м���
			ServerSocket serverSocket = new ServerSocket(8888);
			// 2,����accept()��������ʼ����
			System.out.println("***�����������������ȴ��ͻ�������***");
			Socket socket = serverSocket.accept();
			// 3����ȡ����������ȡ�ͻ��˷��͵���Ϣ
			InputStream is = socket.getInputStream();// �ֽ���
			InputStreamReader isr = new InputStreamReader(is);// �ַ���
			BufferedReader br = new BufferedReader(isr);// Ϊ��������ӻ���
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("���Ƿ��������ͻ���˵��" + info);
			}
			socket.shutdownInput();
			// 4,�ر���Դ
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
