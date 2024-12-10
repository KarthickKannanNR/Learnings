package com.java.Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

interface Topic{
	void understand();
	
	static void add() {};
	static void add2() {};

}

class Topic1 implements Topic{

	@Override
	public void understand() {
		System.out.println("Understand");
		
	}
	
}


class serializableClass implements Serializable{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 8499067155265509635L;
	   	
	   int i; 
	   String s; 
	    String k;
	    public serializableClass(int i,String s,String k) 
	    { 
	        this.i = i; 
	        this.s = s; 
	        this.k = k;
	    } 
	    
	    
	    private void writeObject(ObjectOutputStream oi) throws IOException, ClassNotFoundException{
	    	s = Base64.getEncoder().encodeToString(s.getBytes());
	    	k = Base64.getEncoder().encodeToString(k.getBytes());
	    	oi.defaultWriteObject();
	    	oi.writeObject(s);
	    	oi.writeObject(k);
	    }
	    
	    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	        in.defaultReadObject();  // Read other fields
	        String s = (String) in.readObject();  // Read the encrypted name
	        String k = (String) in.readObject();  // Read the encrypted name
	        this.s = new String(Base64.getDecoder().decode(s));  // Decrypt the name
	        this.k = new String(Base64.getDecoder().decode(k));  // Decrypt the name
	    }
}
public class Runner {

	public static void serializationExample() throws IOException, ClassNotFoundException {
		
		serializableClass s1 =  new serializableClass(27, "karthick","kannan");
		
		// Serializing 'serializableClass' 
        FileOutputStream fos = new FileOutputStream("D:\\serialize.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        
        
        //DeSerializing
        FileInputStream fis = new FileInputStream("D:\\serialize.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        serializableClass s2 =  (serializableClass) ois.readObject(); 
        System.out.println(s2.i);
        System.out.println(s2.s);
        System.out.println(s2.k);
        
	}
	
	public static void IntegerCheck() {
		Integer n = 120;
		Integer n2 = 120;
		
		System.out.println(n == n2);
	}
	
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		IntegerCheck();

	}

}
