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

		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;

		// ����һ�£�����̨�߳̾��������
		try {
			armyOfRevolt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Stage().start();

	}

}
