package com.srie.concurrent.base;

/**
 * 隋唐演义的大戏舞台
 * 
 * @author ThinkPad
 *
 */
public class Stage extends Thread {

	@Override
	public void run() {
		System.out.println("欢迎观看隋唐演义");
		//让观众安静片刻，等待大戏上演
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		System.out.println("大幕徐徐拉开");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		System.out.println("话说隋朝末年，隋军与起义军杀的昏天黑地...");
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

		// 使用Runnable接口创建线程
		Thread armyOfSuiDynastry = new Thread(armyTaskOfSuiDynasty, "隋军");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");

		// 启动线程，让军队开始作战
		armyOfSuiDynastry.start();
		armyOfRevolt.start();

		// 舞台线程休眠，大家专心观看军队厮杀
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("正当双方激战正酣，半路杀出来个程咬金");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");

		// 军队停止作战
		// 停止线程的方法
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;

		//stop方法是抛弃的停止线程的方法
//		armyOfSuiDynastry.stop();
//		armyOfRevolt.stop();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		/*
		 * 历史大戏留给关键人物
		 */
		mrCheng.start();

		// 万众瞩目，所有线程等待程先生完成历史使命
		try {
			mrCheng.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
		System.out.println("谢谢观看隋唐演义，再见！");

		// 调用一下，让舞台线程尽快结束；
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
