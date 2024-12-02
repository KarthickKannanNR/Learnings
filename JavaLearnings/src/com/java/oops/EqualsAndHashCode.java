package com.java.oops;

public class EqualsAndHashCode {

	class Car{
		String name;
		int noOfWheels;
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			 int result = name.hashCode();
		     result = 31 * result + noOfWheels; // Hash code calculation
		     return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(this == obj) return true;
			if(obj == null || getClass() != obj.getClass()) return false;
			Car car = (Car) obj;
			return noOfWheels == car.noOfWheels && name.equals(car.name);
		}
		
	}
	
	public static void main(String[] args) {
		EqualsAndHashCode obj = new EqualsAndHashCode();
		obj.checkEqualsAndHashcode();
	}
	
	public void checkEqualsAndHashcode() {
		Car car = new Car();
		car.name="Honda";
		car.noOfWheels = 4;
		
		Car car2 = new Car();
		car2.name = "Honda";
		car2.noOfWheels = 40;
		
	    System.out.println(car.equals(car2));
	}
}
