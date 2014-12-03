package com.srie.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			// �����ͻ���Socket��ָ����������ַ�Ͷ˿�
			Socket socket = new Socket("127.0.0.1", 8888);
			// ��ȡ���������������˷��������
			OutputStream os = socket.getOutputStream();// �ֽ������
			PrintWriter pw = new PrintWriter(os);// ��װΪ��ӡ��
			pw.write("�û���:admin;����:123");
			pw.flush();
			socket.shutdownOutput();// �ر������
			//pw.close();//�˴��ر��˾ͻᵼ��socket�ر��ˣ�
			// ��ȡ������
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(isr);
			String info = null;
			while ((info = bf.readLine()) != null) {
				System.out.println("���ǿͻ��ˣ���������˵��" + info);
			}
			// �ر�������Դ
			bf.close();
			isr.close();
			is.close();
			pw.close();
			os.close();
			socket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
