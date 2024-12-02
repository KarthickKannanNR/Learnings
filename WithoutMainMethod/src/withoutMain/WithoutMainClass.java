package withoutMain;

public class WithoutMainClass {
	 static {
	        NestedClass.printMessage();
	 }
	 static {
	        NestedClass.printMessage();
	 }
	    static class NestedClass {
	        static void printMessage() {
	            System.out.println("Message from nested class");
	        }
	    }
	
	public static void main(String[] args) {
		System.out.println("hiii");
	}
}
