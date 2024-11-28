package com.java.oops;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Implementor impl = new Implementor();
		impl.print();
		impl.printFromAbstractClass();
		impl.add(2, 3);
	}

}
