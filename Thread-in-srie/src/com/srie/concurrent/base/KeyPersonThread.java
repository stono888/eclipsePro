package com.srie.concurrent.base;

public class KeyPersonThread extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "��ʼ��ս��");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()
					+ "��ͻ��ɱ���������...");
		}
		System.out.println(Thread.currentThread().getName() + "������ս��");
	}
}
