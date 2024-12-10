package com.java.concepts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Externalizable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class IoConcepts2{

	public static void fileReader() throws IOException {
		FileReader fr = new FileReader("E:\\SPRING_BOOT\\JavaLearnings\\src\\com\\java\\concepts\\IoConcepts2.java");
		int data;
		
		while((data = fr.read()) !=-1) {
			System.out.println((char) data);
		}
	}
	
	private Object readResolve() throws ObjectStreamException{
		return null;
		
	}
	
	
	public static void bufferedReader()throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("E:\\\\SPRING_BOOT\\\\JavaLearnings\\\\src\\\\com\\\\java\\\\concepts\\\\IoConcepts2.java"));
		String line;
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\SPRING_BOOT\\JavaLearnings\\src\\com\\java\\concepts\\IoConcepts2.java"));
		while((line = bf.readLine())!=null) {
			System.out.println(line);
			line = line.replaceAll("IoConcepts2", "IoConcepts2");
			bw.write(line);
			bw.flush();
			bw.newLine();
		}
		bw.close();
		bf.close();
		
		
	}
	
	   private void writeObject(ObjectOutputStream out) throws IOException   
	    {   
	        throw new NotSerializableException();   
	    }   
	    private void readObject(ObjectInputStream in) throws IOException   
	    {   
	        throw new NotSerializableException();   
	    }   
	
	
	public static void main(String[] args) throws IOException {
		bufferedReader();
	}


}
