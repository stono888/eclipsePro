package com.srie.concurrent.base;

/**
 * ��������Ĵ�Ϸ��̨
 * 
 * @author ThinkPad
 *
 */
public class Stage extends Thread {

	@Override
	public void run() {
		System.out.println("��ӭ�ۿ���������");
		//�ù��ڰ���Ƭ�̣��ȴ���Ϸ����
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		System.out.println("��Ļ��������");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		System.out.println("��˵�峯ĩ�꣬����������ɱ�Ļ���ڵ�...");
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

		// ʹ��Runnable�ӿڴ����߳�
		Thread armyOfSuiDynastry = new Thread(armyTaskOfSuiDynasty, "���");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "ũ�������");

		// �����̣߳��þ��ӿ�ʼ��ս
		armyOfSuiDynastry.start();
		armyOfRevolt.start();

		// ��̨�߳����ߣ����ר�Ĺۿ�������ɱ
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("����˫����ս��������·ɱ��������ҧ��");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		System.out.println("��ҧ���������ǽ���ս����ʹ���հ�����ҵ��");

		// ����ֹͣ��ս
		// ֹͣ�̵߳ķ���
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;

		//stop������������ֹͣ�̵߳ķ���
//		armyOfSuiDynastry.stop();
//		armyOfRevolt.stop();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		/*
		 * ��ʷ��Ϸ�����ؼ�����
		 */
		mrCheng.start();

		// ������Ŀ�������̵߳ȴ������������ʷʹ��
		try {
			mrCheng.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("ս�����������񰲾���ҵ��������ʵ���˻������������룬Ϊ���������˹��ף�");
		System.out.println("лл�ۿ��������壬�ټ���");

		// ����һ�£�����̨�߳̾��������
		// try {
		// armyOfRevolt.join();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

	}

	public static void main(String[] args) {
		new Stage().start();

	}

}
