package com.java8.staticMethods;

public class FinalClass {
	
	public static void main(String[] args) {
		FinalClass2 obj = new FinalClass2(100);
		System.out.println(FinalClass2.a);
		System.out.println(obj.change2());
		System.out.println(FinalClass2.change());
	}
	

}

class FinalClass2 {
	 static int a =20;

	 FinalClass2(int a){
		 FinalClass2.a=a;
		}
		public static int change() {
			return a=30;
		}
		
		public int change2() {
			return FinalClass2.a=20;
		}
}


