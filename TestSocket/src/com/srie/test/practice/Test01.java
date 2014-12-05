package com.srie.test.practice;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		System.out.println(address.getAddress().length);
		byte[] bs = address.getAddress();
		for (byte b : bs) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		for (byte b : bs) {
			// System.out.print(Integer.toBinaryString(b)+" ");
			System.out.print(Integer.toString(b & 0xff, 10) + " ");
		}
	}

}
