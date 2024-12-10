package com.java.oops;

public class AbstractRunner{

	public static void main(String[] args) {
		AbstractExample abs = new AbstractExampleImpl();
		abs.print();
		abs.finalMethod();
	}

}
