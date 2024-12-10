package com.java.concepts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommandLineArgsChk {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(args.length);
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
		
		BufferedReader bf = new BufferedReader(new FileReader("E:\\SPRING_BOOT\\JavaLearnings\\src\\com\\java\\concepts\\CommandLineArgsChk.java"));
		String line;
		while((line = bf.readLine()) !=null) {
			System.out.println(line);
		}
		
	}

}
