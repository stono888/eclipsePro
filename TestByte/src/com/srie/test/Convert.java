package com.srie.test;

public class Convert {

	/**
	 * int转化为byte[]
	 * 
	 * @param id
	 * @return
	 */
	public static byte[] int2Bytes(int id) {
		byte[] arr = new byte[4];
		// arr[0] = (byte) ((int) (id >> 0 * 8) & 0xff);
		// arr[1] = (byte) ((int) (id >> 1 * 8) & 0xff);
		// arr[2] = (byte) ((int) (id >> 2 * 8) & 0xff);
		// arr[3] = (byte) ((int) (id >> 3 * 8) & 0xff);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte) ((int) (id >> i * 8) & 0xff);
		}
		return arr;
	}
	/**
	 * long转化为byte[]
	 * 
	 * @param id
	 * @return
	 */
	public static byte[] long2Bytes(int id) {
		byte[] arr = new byte[8];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte) ((int) (id >> i * 8) & 0xff);
		}
		return arr;
	}

	/**
	 * 转化字节数组为int
	 * 
	 * @param arr
	 * @return
	 */
	public static int bytes2Int(byte[] arr) {
		// int rs0 = (int) ((arr[0] & 0xff) << 0 * 8);
		// int rs1 = (int) ((arr[1] & 0xff) << 1 * 8);
		// int rs2 = (int) ((arr[2] & 0xff) << 2 * 8);
		// int rs3 = (int) ((arr[3] & 0xff) << 3 * 8);
		// return rs0 + rs1 + rs2 + rs3;
		int rs = 0;
		for (int i = 0; i < arr.length; i++) {
			rs += (int) ((arr[i] & 0xff) << i * 8);
		}
		return rs;

	}
	/**
	 * 转化字节数组为long
	 * 
	 * @param arr
	 * @return
	 */
	public static long bytes2Long(byte[] arr) {
		long rs = 0;
		for (int i = 0; i < arr.length; i++) {
			rs += (long) ((arr[i] & 0xff) << i * 8);
		}
		return rs;
		
	}

	public static void main(String[] args) {
		byte[] arr = int2Bytes(8143);
		System.out.println(arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3]);
		int i = 8143;
		System.out.println((int) (i >> 0 * 8 & 0xff));
		System.out.println(bytes2Int(arr));
		//字符串与字节数组
		String describe = "我每天都练功，我天下无敌...";
		byte[] barr = describe.getBytes();
		
		String des = new String(barr);
		System.out.println(des);
		
		String t = "8143";
		byte[] tarr = t.getBytes();
		System.out.println(tarr.length);
		System.out.println((int)(tarr[0]&0xff));
		
		
	}

}
