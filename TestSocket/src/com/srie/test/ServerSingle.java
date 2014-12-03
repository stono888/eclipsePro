package com.srie.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ���Socketͨ�ţ���������
 * 
 * @author ThinkPad
 *
 */
public class ServerSingle {

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
			// 4����ȡ�����
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("��ӭ����");
			pw.flush();//ˢ�»���
			
			
			// 5,�ر���Դ
			pw.close();
			os.close();
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
