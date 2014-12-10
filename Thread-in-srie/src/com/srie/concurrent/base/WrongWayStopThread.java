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
			// // 减少屏幕输出的空循环
			// }
			/*
			 * 下面这种写法是不行的；在Sleep的时候调用Interrupt方法，会导致出现一个InterruptedException,
			 * 并且isInterrupted并没有进行设置；
			 */
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				// 如果出现了异常，再次进行interrupt()方法的调用；
				 this.interrupt();
			}
		}
	}

}
