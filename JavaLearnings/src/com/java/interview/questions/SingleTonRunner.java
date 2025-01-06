package com.java.interview.questions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Predicate;

public class SingleTonRunner {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingleTon instance = SingleTon.createInstance();
		ObjectOutputStream os = new ObjectOutputStream(
				new FileOutputStream("C:\\Users\\kart2921\\Downloads\\home.txt"));
		os.writeObject(instance);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\kart2921\\Downloads\\home.txt"));
		SingleTon instance2 = (SingleTon) ois.readObject();
		System.out.println(instance.hashCode());
		// SingleTon instance2 = SingleTon.createInstance();
		System.out.println(instance2.hashCode());

		//breaking the singleton concept using reflection
		Class<?> singleTon = SingleTon.class;
		Constructor<?>[] cons = singleTon.getDeclaredConstructors();
		for(Constructor<?> con:cons) {
			con.setAccessible(true);
		}
		SingleTon s = (SingleTon)cons[0].newInstance();
		System.out.println(s.hashCode());
		
		/*
		 * Thread t;
		 * 
		 * for(int i=0;i<20;i++) { t= new Thread(new CreateObjectByThread()); t.start();
		 * }
		 */
		 
	}
}

class CreateObjectByThread implements Runnable {

	@Override
	public void run() {
		SingleTon instance = null;
		try {
			instance = SingleTon.createInstance();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(instance.hashCode());

	}

}
