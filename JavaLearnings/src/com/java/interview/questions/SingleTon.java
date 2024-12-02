package com.java.interview.questions;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingleTon{
	private static SingleTon instance = null;
	private int value;
	
	
	private SingleTon() {
		
	}
	
	public static SingleTon createInstance() {
		if(instance == null) {
			synchronized (SingleTon.class) {
				if(instance == null) {
					return instance = new SingleTon(); 		
				}
			}
	    }
		
		return instance;
	}
	
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}

}


