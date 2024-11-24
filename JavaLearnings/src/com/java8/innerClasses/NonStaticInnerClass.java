package com.java8.innerClasses;

public class NonStaticInnerClass {
    public String outerField = "Outer Field";
    public static String staticOuterfield = "Static Outer Field";
	
	class MemberInnerClass{
		int innerClassVar =1;
		
		void display() {
			System.out.println(outerField);
			int finalInnerClassVar =1;
			 class localInnerClass{
				static int finalInnerClassVar =1; 
				public void display() {
					System.out.println(finalInnerClassVar);
				}
			}
		}
	}
	
	static class StaticInnerClass {
		public void display() {
			System.out.println(staticOuterfield);
		}
	}
	
	public void get(NonStaticInnerClass ref) {
		staticOuterfield =null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(args.length>0?args[0]:0);
		NonStaticInnerClass outer = new NonStaticInnerClass();
		String staticOuterfield2 = outer.staticOuterfield;
		NonStaticInnerClass.MemberInnerClass inner = outer.new MemberInnerClass();
		inner.display();
		NonStaticInnerClass outer1 = outer;

		NonStaticInnerClass.StaticInnerClass staticClass =  new NonStaticInnerClass.StaticInnerClass();
		staticClass.display();
	}

}
