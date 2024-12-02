package com.java.Multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletebleFuture2 {
	
	public static void main(String[] args) {
		User user = new User();
		UserProfileService user2 = new  UserProfileService();
		int num = 1;
		
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()-> user.fetchUserFromDatabase(num));
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()-> user2.fetchUserProfile(num));
		
		CompletableFuture<String> combinedFuture = future1.thenCombine(future2,
				(a,b) -> a +" "+b);
		
		try {
			String result =  combinedFuture.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class User{
	 public String fetchUserFromDatabase(int userId) {
	        // Simulate a delay for database call
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return "User" + userId;
	    }
}

class UserProfileService {
    public String fetchUserProfile(int userId) {
        // Simulate a delay for web service call
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Profile for User" + userId;
    }
}
