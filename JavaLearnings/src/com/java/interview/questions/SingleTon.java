package com.java.interview.questions;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingleTon implements Serializable{
	private static SingleTon instance = null;
	private int value;
	
	
	private SingleTon() throws IllegalAccessException {
		if(instance != null) {
			throw new IllegalAccessException("SingleTon instance is already created");
		}
	}
	
	public static SingleTon createInstance() throws IllegalAccessException {
		if(instance == null) {
			synchronized (SingleTon.class) {
				if(instance == null) {
					return instance = new SingleTon(); 		
				}
			}
	    }
		
		return instance;
	}
	
	//Protecting by avoid crating a new instance for singleton class while deserializing
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
	
	
	//Protecting by avoid crating a new instance for singleton class while cloning
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone is not supported for Singleton class");
	}

}


