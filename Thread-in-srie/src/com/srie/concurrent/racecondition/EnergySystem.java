package com.srie.concurrent.racecondition;

/**
 * 宇宙的能量系统 遵循能量守恒定律： 能量不会凭空创生或消失，只会从一处转移到另一处
 * 
 * @author ThinkPad
 *
 */
public class EnergySystem {

	// 能量盒子，能量存贮的地方
	private final double[] energyBoxes;
	private final Object lockObj = new Object();

	/**
	 * @param n
	 *            能量盒子的数量
	 * @param initialEnergy
	 *            每个能量盒子初始含有的能量值
	 */
	public EnergySystem(int n, double initialEnergy) {
		energyBoxes = new double[n];
		for (int i = 0; i < energyBoxes.length; i++) {
			energyBoxes[i] = initialEnergy;
		}
	}

	/**
	 * 能量的转移，从一个盒子到另一个盒子
	 * 
	 * @param from
	 *            能量源
	 * @param to
	 *            能量终点
	 * @param amount
	 *            能量值
	 */
	// 直接在方法上面加synchronized也可以实现线程安全，但是没有进行业务逻辑优化
	// 打开下面的if(energyBoxes[from]<amount)注释，会发现有大量的重复的线程申请
	// synchronized
	public void transfer(int from, int to, double amount) {
		// 通过对lockObj加锁来实现互斥行为；
		synchronized (lockObj) {
			// if (energyBoxes[from] < amount) {
			// System.out.println("能量盒子:"+from+"的能量"+energyBoxes[from]+"小于能量"+amount);
			// return;
			// }
			// while循环，保证条件不满足时任务都会被条件阻挡
			// 而不是继续竞争CPU资源
			// Wait set ,所有等待线程的集合；
			while (energyBoxes[from] < amount) {
				try {
					// 使线程处于等待状态，避免线程重复申请锁；
					System.out.println("能量盒子:" + from + "的能量"
							+ energyBoxes[from] + "小于能量" + amount);
					// 条件不满足，将当前线程放入Wait Set
					lockObj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName());
			energyBoxes[from] -= amount;
			System.out.printf("从%d转移%10.2f单位能量到%d", from, amount, to);
			energyBoxes[to] += amount;
			System.out.printf("能量总和：%10.2f%n", getTotalEnegies());
			// 唤醒所有在lockObj对象上等待的线程；
			lockObj.notifyAll();
			// notifyAll()方法和wait()方法不是在同一个线程的同一次操作中执行的；
		}
	}

	/**
	 * 获取能量世界的能量总和
	 * 
	 * @return
	 */
	public double getTotalEnegies() {
		double sum = 0;
		for (double amount : energyBoxes) {
			sum += amount;
		}
		return sum;
	}

	/**
	 * 返回能量盒子的长度
	 * 
	 * @return
	 */
	public int getBoxAmount() {
		return energyBoxes.length;
	}
}
