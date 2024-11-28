package com.java.learnings.java8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Java8Features {
	
	public static void threadStatus() {
		System.out.println("Thread is running");
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		ThreadClass tc = new ThreadClass();
		tc.run();
		streamApiEx();
		Product product =  new Product(0, null, 0);
		Class cls = product.getClass();
		Method[] methodsc = cls.getMethods();
		Thread thread = new Thread(Java8Features::threadStatus);
		lamdaFunction();
		for(Method methods:methodsc) {
			System.out.println(methods.getName());
			Parameter parameter[] = methods.getParameters();
			System.out.println();
			for (Parameter parameter2 : parameter) {  
                System.out.print(""+parameter2.getParameterizedType()); // returns type of parameter  
                System.out.print(""+parameter2.getName()); // returns parameter name  
            }  
		}
	}  
	
	static void streamApiEx() {
		 List<Product> productsList = new ArrayList<Product>();  
	        //Adding Products  
	        productsList.add(new Product(1,"HP Laptop",25000f));  
	        productsList.add(new Product(2,"Dell Laptop",30000f));  
	        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
	        productsList.add(new Product(4,"Sony Laptop",28000f));  
	        productsList.add(new Product(5,"Apple Laptop",90000f)); 
	        productsList.add(new Product(6,"ROG Laptop",90000f));  
	        
	        productsList.stream().filter(p->p.price > 30000).map(p->p.price).forEach(System.out::println); 
	        
	        Stream.iterate(1, element->element+3)  
	        .filter(element->element%5==0)  
	        .limit(5)  
	        .forEach(System.out::println);  
	        
	        Float totalPrice1 = productsList.stream().map(product -> product.price).reduce(0.0f, (sum,price) -> sum + price);
	        System.out.println(totalPrice1);
	        
	        //Using method reference
	        Float totalPrice2 = productsList.stream().map(product -> product.price).reduce(0.0f, Float::sum);
	        System.out.println(totalPrice2);
	        
	        System.out.println(productsList.stream().collect(Collectors.summarizingDouble(p -> p.price)));
	        
	        //find max and min
	        System.out.println(productsList.stream().min((product1,product2) -> product1.price > product2.price?1:-1).get().price);
	         	        
	        //finding count
	        System.out.println(productsList.stream().filter(product -> product.price < 30000).count());
	        
	        //convert List to Set
	       Set<Float> productSet = productsList.stream().map(product -> product.price).collect(Collectors.toSet());
	       System.out.println(productSet);
	       
	     //convert List to Map
	       Map<String, Float> filteredMap = productsList.stream().filter(p -> p.price > 30000).collect(Collectors.toMap(p -> p.name, p -> p.price));
	       System.out.println(filteredMap);
	       
	       System.out.println(productsList.stream().collect(Collectors.groupingBy(prod -> prod.price,Collectors.counting())));
	       
	       List<Integer> nums = Arrays.asList(1,2,3,4,6,1,8,90,100);
	       System.out.println("second smallest num "+nums.stream().distinct().sorted().skip(1).findFirst().orElse(null));
	       System.out.println("second largest num "+nums.stream().distinct().sorted((a,b) -> Integer.compare(b,a)).skip(1).findFirst().orElse(null));
	       
	       //FlatMap
	       List<List<Integer>> listOfList = new ArrayList<>();
	       listOfList.add(Arrays.asList(1,2));
	       listOfList.add(Arrays.asList(3,4));
	       listOfList.add(Arrays.asList(5,6));
	       listOfList.add(Arrays.asList(7,8));
	       listOfList.add(Arrays.asList(9,10));
	       
	       List<Integer> flattenList = listOfList.stream().flatMap(list->list.stream()).collect(Collectors.toList());
	       System.out.println(flattenList);
	       
	       
	       //base64 encodig and decoding
	       
	       Base64.Encoder encoder = Base64.getEncoder(); 
	       byte byteArr1[] = {1,2};
	       System.out.println("Encoded byteArr "+encoder.encode(byteArr1));
	       Base64.Decoder decoder = Base64.getDecoder();
	       
	       byte byteArr2[] = new byte[5];
	       encoder.encode(byteArr1,byteArr2);
	       System.out.println(byteArr2);
	       	
	       String encodedString = encoder.encodeToString("karthick".getBytes());
	       System.out.println("encoded string "+ encodedString);
	       
	      String decodedString = new String(decoder.decode(encodedString));
	      System.out.println(decodedString);
	      
	      Base64.Encoder urlEncoder = Base64.getUrlEncoder();
	      Base64.Decoder urlDecoder = Base64.getUrlDecoder();
	      System.out.println("Encoded URl :"+ urlEncoder.encodeToString("http://www.javatpoint.com/java-tutorial/".getBytes()));
	      String encodeUrl = urlEncoder.encodeToString("http://www.javatpoint.com/java-tutorial/".getBytes());
	      System.out.println("Decoded URl :"+new String(urlDecoder.decode(encodeUrl)));
	}
	
    static void addList(List<Integer> list){  
        // Return sum of list values  
        int result = list.stream()  
                   .mapToInt(Integer::intValue)  
                   .sum();  
        System.out.println("Sum of list values: "+result);  
    }  

	public static void lamdaFunction() throws InterruptedException {
		
		Runnable r1 = ()->{
			System.out.println("runnable");
		};
		Thread t1 = new Thread(r1);
		t1.start();
		t1.sleep(2000);
		
		Addable addable = (a,b)->{return a+b;}; 
		//System.out.println("Implement of functional interface using Lamda Expression \n"+addable.add("karthick","kiruba")+"\n");
		System.out.println(addable.add(1,2));
		
		//ForEach
		System.out.println("ForEach:");
        List<String> list= Arrays.asList("karthick","kiruba","ajees","nethaji");
        list.forEach((val)->System.out.println(val));
        
        Collections.sort(list,(val1,val2) ->{
        	return val1.compareTo(val2);
        });
        System.out.println(list);
        
        Consumer<List<Integer>> total= Java8Features::addList;
		total.accept(Arrays.asList(1,2,3,4,5));
	}
	
	public static void java8NewFeatures() {
		//Finding occurrence of each element
		List<Integer> numbers = Arrays.asList(2,5,1,6,7,8,1,23,4,9,0,1,2,3,6,1,2,7,2,3,5);
		Map<Integer,Integer> frequencyMap = numbers.stream().collect(Collectors.toMap(num -> num, num ->Collections.frequency(numbers, num),(extVal,newVal) -> extVal));
		System.out.println("Frequency Map = "+frequencyMap);
		
		//Collections.disjoint compare 2 collections having common element
		List<Integer> list1 = new ArrayList<>();
		Collections.addAll(list1, 1,2,3,4,5);
		
		List<Integer> list2 = new ArrayList<>();
		Collections.addAll(list2, 8,14,25);
		
		System.out.println("List1 and List2 doesn't have any common elements : "+Collections.disjoint(list1, list2));
		
		
		//Collections.singleTon To create a immutable single collection instance
		Set<String> singleObject = Collections.singleton("Karthick");
		
		try {
			singleObject.add("kannan");
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		//Collections.rotate
		List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Collections.rotate(numberList, 3);
		System.out.println(numberList);
	}

}
