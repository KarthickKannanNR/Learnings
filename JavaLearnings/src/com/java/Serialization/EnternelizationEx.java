package com.java.Serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class externalization implements Externalizable{

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(i);
		out.writeObject(s);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		i = in.readInt();
		s= (String) in.readObject();
		
	}
	
	   int i; 
	   String s; 
	  
	    public externalization(int i,String s) 
	    { 
	        this.i = i; 
	        this.s = s; 
	    } 
}

public class EnternelizationEx {
	final int num = 0;

	public  static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		externalization e = new externalization(1,"karthick");
       FileOutputStream fos = new FileOutputStream("D:\\serialize.txt"); 
	    ObjectOutputStream oos = new ObjectOutputStream(fos); 
	    oos.writeObject(e); 
	    
	    
	    FileInputStream fis = new FileInputStream("D:\\serialize.txt"); 
        ObjectInputStream ois = new ObjectInputStream(fis); 
        externalization e1 =  (externalization) ois.readObject(); 
		

	}

}
