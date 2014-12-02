package com.srie.test2;

public class ClassDemo1 {

	public static void main(String[] args) {
		String string = "hello";
		Foo foo = new Foo();
		ClassUtil2.printClassMethod(foo);
		System.out.println("======================");
		ClassUtil2.printClassDeclaredMethod(foo);
		
	}

}

class Foo {

	private String printString() {
		return "printString";
	}

	public String printString2() {
		return printString() + "!";
	}
}