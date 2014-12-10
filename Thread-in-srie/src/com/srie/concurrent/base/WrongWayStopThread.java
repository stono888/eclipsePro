package com.srie.concurrent.base;

public class WrongWayStopThread extends Thread {

	public static void main(String[] args) {
		WrongWayStopThread thread = new WrongWayStopThread();
		System.out.println("Starting thread......");
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Interrupting thread......");
		thread.interrupt();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Stopping application");

	}

	@Override
	public void run() {
		// while (true) {
		while (!this.isInterrupted()) {
			System.out.println("Thread is running...");
			// long time = System.currentTimeMillis();
			// while (System.currentTimeMillis() - time < 1000) {
			// // ������Ļ����Ŀ�ѭ��
			// }
			/*
			 * ��������д���ǲ��еģ���Sleep��ʱ�����Interrupt�������ᵼ�³���һ��InterruptedException,
			 * ����isInterrupted��û�н������ã�
			 */
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				// ����������쳣���ٴν���interrupt()�����ĵ��ã�
				 this.interrupt();
			}
		}
	}

}
