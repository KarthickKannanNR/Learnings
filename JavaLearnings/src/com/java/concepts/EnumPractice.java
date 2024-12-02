package com.java.concepts;

public enum EnumPractice {

	
	
	COW {
		@Override
        public void sound() {
            System.out.println("Moo");
        }
    };
	
	public abstract void sound();
	
}
