package org.example;

public class EasyProblems {

    public static void main(String[] args) {
        int n = 50;
        System.out.println("No of Factorial of "+ n + " is "+ findNoOfFactorials(n));
    }

    public static int findNoOfFactorials(int num){
        int count = 0;
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num % i == 0) {
                if (i == num / i) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

}
