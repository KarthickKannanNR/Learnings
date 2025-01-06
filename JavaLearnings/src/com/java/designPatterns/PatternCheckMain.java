package com.java.designPatterns;

public class PatternCheckMain {

	public static void main(String[] args) {                                                                

		User user = new User().setAge(27)
				              .setName("karthick kannan")
				              .setUserId(56);
		
		System.out.println(user.getAge());
	}

}
