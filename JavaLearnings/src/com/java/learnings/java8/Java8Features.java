package com.java.learnings.java8;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RunnableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.Multithreading.InterruptExample;


public class Java8Features extends InterruptExample{
	
	public static void threadStatus() {
		System.out.println("Thread is running");
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		/*
		 * ThreadClass tc = new ThreadClass(); tc.run(); streamApiEx(); Product product
		 * = new Product(0, null, 0); Class cls = product.getClass(); Method[] methodsc
		 * = cls.getMethods(); Thread thread = new Thread(Java8Features::threadStatus);
		 * for(Method methods:methodsc) { System.out.println(methods.getName());
		 * Parameter parameter[] = methods.getParameters(); System.out.println(); for
		 * (Parameter parameter2 : parameter) {
		 * System.out.print(""+parameter2.getParameterizedType()); // returns type of
		 * parameter System.out.print(""+parameter2.getName()); // returns parameter
		 * name } }
		 * 
		 * CopyOnWriteArrayList<Integer> nums = new
		 * CopyOnWriteArrayList<>(Arrays.asList(1,3,4,5,5));
		 * 
		 * for(int i:nums) { System.out.println(i); nums.add(10); }
		 */
		//java8NewFeatures();
		PostJava8Date();

	}  
	
	static void streamApiEx() {
		 List<Product> productsList = new ArrayList<Product>();  
		 
		     Integer[] arr = new Integer[] { 100, 100, 9, 8, 200 };

		     Arrays.stream(arr).mapToInt(num->num*num)
		                       .filter(numTotal -> numTotal >100)
		                       .average();
		     
		     
		     Arrays.stream(arr).mapToInt(Integer::intValue).sum();
		 
		 	System.out.println("random numbrs");
		    new Random().ints().limit(5).sorted().forEach(System.out::println);
		    ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
	    	map.put(1, "uyfguyg");

		    for (Map.Entry<Integer, String> entry : map.entrySet()) {
		        // Process entry
		    	System.out.println(entry.getValue());
		    	map.put(1, "abc");
		    }
		    
		    HashMap<Integer, String> jyg = new HashMap<>();
		    jyg.put(1, "hashmap");
		    
		    for (Map.Entry<Integer, String> entry : jyg.entrySet()) {
		        // Process entry
		    	System.out.println(entry.getValue());
		    	map.put(1, "abc");
		    }

		    List<Integer> numList = new ArrayList<>(Arrays.asList(1,5,1,2,6,8,3,5,9));
		 	numList.add(2,89);
		     Arrays.parallelSort(arr);
		 	System.out.println(numList.stream().mapToInt(Integer::intValue).summaryStatistics());
		 	System.out.println(numList.stream().reduce(0,(num1,num2)->num1+num2)); 
		 	numList.stream().mapToInt(Integer::intValue).average();
		 	
		 	
		 	
		    int total = numList.stream().filter(num -> num%2 !=0).mapToInt(Integer::intValue).sum();
		    int total2 = numList.stream().filter(num -> num%2 !=0).collect(Collectors.summingInt(n -> n));
		    
		    
		    System.out.println(numList.stream().filter(num -> num%2 !=0).reduce(Integer::sum).get()); 
		    System.out.println(total);
		    System.out.println(total2);
		    
		    numList.stream().reduce(Integer::max);
		    
	        //Adding Products  
	        productsList.add(new Product(1,"HP Laptop",25000f));  
	        productsList.add(new Product(2,"Dell Laptop",30000f));  
	        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
	        productsList.add(new Product(4,"Sony Laptop",28000f));  
	        productsList.add(new Product(5,"Apple Laptop",90000f)); 
	        productsList.add(new Product(6,"ROG Laptop",90000f));  
	        
	        //filtering max price product
	        System.out.println("Max priced product");
	        productsList.stream().max((p1,p2)->p1.price>p2.price?1:-1).stream().toList().forEach(System.out::println);        
	        System.out.println("list is ordered");
	        productsList.forEach(System.out::println);
	        
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
	        System.out.println("min "+productsList.stream().min((product1,product2) -> product1.price < product2.price?-1:1).get().price);
	         	        
	        //finding count
	        System.out.println(productsList.stream().filter(product -> product.price < 30000).count());
	        
	        //convert List to Set
	       Set<Float> productSet = productsList.stream().map(product -> product.price).collect(Collectors.toSet());
	       System.out.println(productSet);
	       
	     //convert List to Map
	       Map<String, Float> filteredMap = productsList.stream().filter(p -> p.price > 30000).collect(Collectors.toMap(p -> p.name, p -> p.price));
	       System.out.println(filteredMap);
	       filteredMap.put(null, null);
	       
	       HashSet<Integer> uhg = new HashSet<>();
	       uhg.add(null);
	       uhg.add(null);
	        
	       System.out.println("///////////////");
	       uhg.forEach(System.out::println);
	       
//	       Hashtable<String, Integer> jhg = new  Hashtable<>();
//	       jhg.put(null, null);
	       
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
	      
	      System.out.println("spliterator ");
	      List<String> list = Arrays.asList("A", "B", "C", "D", "E");
	        Spliterator<String> spliterator = list.spliterator();
	        System.out.println(Spliterator.ORDERED);
	        // Try splitting
	        Spliterator<String> split = spliterator.trySplit();

	        // Process elements in the original spliterator
	        System.out.println(spliterator.characteristics());

	        spliterator.forEachRemaining(System.out::println); // Output remaining elements
		      System.out.println("spliterator ");

	        // Process elements in the split spliterator
	      split.tryAdvance(System.out::println); // Output split elements
	       System.out.println("tryAdvance check");
	       
	       
	       

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
		System.out.println("max :"+numberList.stream().max(Comparator.comparing(Function.identity())).get());
		
		
		List<Integer> arr1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		List<Integer> arr2 = new ArrayList<>(Arrays.asList(6,7,8,9,10));
		
	    System.out.println(Arrays.asList(arr1,arr2).stream().flatMap(List::stream).toList());	 
	    
	    List<Integer> list11 = Arrays.asList(2, 5, 1, 6, 7, 8, 1, 23, 4, 9, 0, 1, 2, 3);
        List<Integer> list12 = Arrays.asList(1, 3, 6, 9, 7, 23, 8);

        // Using retainAll() to get common elements
        List<Integer> commonElements = new ArrayList<>(list11);  // Create a copy of list1
        commonElements.retainAll(list12); 
        System.out.println("commonElements in list11 and list12 : "+ commonElements);
        
        //stream.iterate
        Stream<Integer> infiniteStream = Stream.iterate(1, n -> n + 1);
        infiniteStream.limit(10).forEach(System.out::println);
        
        Stream<Integer> iterateStream = Stream.iterate(1, n -> n <=12,n -> n + 1);
        System.out.println(iterateStream.toList());
        
        
        //stream.generate
        Stream<Double> generateStream = Stream.generate(()->Math.random());
        generateStream.limit(10).forEach(System.out::println);


		

	}
	
	public static void preJava8Date() {
	        // Using java.util.Date
	        Date date = new Date();
	        System.out.println("Current Date: " + date);
	        System.out.println(date.getYear());

	        // Using java.util.Calendar
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(2024, 10, 10);
	        Date customDate = calendar.getTime();
	        System.out.println("Custom Date: " + customDate);
	}
	
	public static void PostJava8Date() {
	        // Using LocalDate (immutable)
	        LocalDate today = LocalDate.now();
	        System.out.println("Today: " + today);

	        // Using LocalDateTime (immutable)
	        LocalDateTime now = LocalDateTime.now();
	        System.out.println("Current Date and Time: " + now);
	        
	        
	        // Using ZonedDateTime (time zone aware)
	        ZonedDateTime zonedNow = ZonedDateTime.now();
	        System.out.println("Current Date and Time with Time Zone: " + zonedNow);

	        // Parsing date and time
	        String dateString = "2024-10-10";
	        LocalDate customDate = LocalDate.parse(dateString);
	        System.out.println("Parsed Date: " + customDate);

	        // Formatting date
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String formattedDate = today.format(formatter);
	        System.out.println("Formatted Date: " + formattedDate);
	}


}
