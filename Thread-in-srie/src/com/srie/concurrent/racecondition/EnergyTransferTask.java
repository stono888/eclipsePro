package com.srie.concurrent.racecondition;

public class EnergyTransferTask implements Runnable {

	// �������������
	private EnergySystem energySystem;
	// ����ת�Ƶ�Դ���������±�
	private int fromBox;
	// ��������ת�����Ԫ
	private double maxAmount;
	// �������ʱ�䣨���룩
	private int DELAY = 0;

	public EnergyTransferTask(EnergySystem energySystem, int fromBox,
			double maxAmount) {
		super();
		this.energySystem = energySystem;
		this.fromBox = fromBox;
		this.maxAmount = maxAmount;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int toBox = (int) (energySystem.getBoxAmount() * Math.random());
				double amount = maxAmount * Math.random();
				energySystem.transfer(fromBox, toBox, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
