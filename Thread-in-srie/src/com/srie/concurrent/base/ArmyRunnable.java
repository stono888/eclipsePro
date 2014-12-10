package com.srie.concurrent.base;

//�����߳�
//ģ��˫����ս����Ϊ
public class ArmyRunnable implements Runnable {

	// volatile��֤���߳̿�����ȷ�Ķ�ȡ�����߳�д���ֵ
	// �ɼ��Է���Ŀ��� �ο�JMM Java�ڴ�ģ�� ��happens-beforeԭ�򣬿ɼ��ԣ�
	volatile boolean keepRunning = true;

	@Override
	public void run() {
		while (keepRunning) {
			// ����5����
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "�����Է�["
						+ i + "]��");
				// �ó��˴�����ʱ�䣬��һ�θ�˭��������һ����!
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName() + "������ս��");
	}

}
