package com.srie.concurrent.racecondition;

/**
 * ���������ϵͳ ��ѭ�����غ㶨�ɣ� ��������ƾ�մ�������ʧ��ֻ���һ��ת�Ƶ���һ��
 * 
 * @author ThinkPad
 *
 */
public class EnergySystem {

	// �������ӣ����������ĵط�
	private final double[] energyBoxes;
	private final Object lockObj = new Object();

	/**
	 * @param n
	 *            �������ӵ�����
	 * @param initialEnergy
	 *            ÿ���������ӳ�ʼ���е�����ֵ
	 */
	public EnergySystem(int n, double initialEnergy) {
		energyBoxes = new double[n];
		for (int i = 0; i < energyBoxes.length; i++) {
			energyBoxes[i] = initialEnergy;
		}
	}

	/**
	 * ������ת�ƣ���һ�����ӵ���һ������
	 * 
	 * @param from
	 *            ����Դ
	 * @param to
	 *            �����յ�
	 * @param amount
	 *            ����ֵ
	 */
	// ֱ���ڷ��������synchronizedҲ����ʵ���̰߳�ȫ������û�н���ҵ���߼��Ż�
	// �������if(energyBoxes[from]<amount)ע�ͣ��ᷢ���д������ظ����߳�����
	// synchronized
	public void transfer(int from, int to, double amount) {
		// ͨ����lockObj������ʵ�ֻ�����Ϊ��
		synchronized (lockObj) {
			// if (energyBoxes[from] < amount) {
			// System.out.println("��������:"+from+"������"+energyBoxes[from]+"С������"+amount);
			// return;
			// }
			// whileѭ������֤����������ʱ���񶼻ᱻ�����赲
			// �����Ǽ�������CPU��Դ
			// Wait set ,���еȴ��̵߳ļ��ϣ�
			while (energyBoxes[from] < amount) {
				try {
					// ʹ�̴߳��ڵȴ�״̬�������߳��ظ���������
					System.out.println("��������:" + from + "������"
							+ energyBoxes[from] + "С������" + amount);
					// ���������㣬����ǰ�̷߳���Wait Set
					lockObj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName());
			energyBoxes[from] -= amount;
			System.out.printf("��%dת��%10.2f��λ������%d", from, amount, to);
			energyBoxes[to] += amount;
			System.out.printf("�����ܺͣ�%10.2f%n", getTotalEnegies());
			// ����������lockObj�����ϵȴ����̣߳�
			lockObj.notifyAll();
			// notifyAll()������wait()����������ͬһ���̵߳�ͬһ�β�����ִ�еģ�
		}
	}

	/**
	 * ��ȡ��������������ܺ�
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
	 * �����������ӵĳ���
	 * 
	 * @return
	 */
	public int getBoxAmount() {
		return energyBoxes.length;
	}
}
