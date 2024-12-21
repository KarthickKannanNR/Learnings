package com.java.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPractice {
	static int ujyg ;
	
	static{
		int i =0;
	    int iy=0;
	    ujyg =78;
	}
	static{
		try {
			int i =0;
		    int iy=0;
		    ujyg =78;
		} catch (ArrayIndexOutOfBoundsException e) {
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void staticChk() throws IOException {
	    ujyg =78;

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//practiceProblemsWithStudents();
		//convertStrToInt();
		convertStrToIntApproach2();
	}
	
	public static void tryWithResourceForStream() throws IOException {
//		Stream<String> fileContent = Files.lines(Paths.get("D:\\sample.txt"));
//		fileContent.forEach(System.out::println);
//		fileContent.close();
		

		
		try(Stream<String> fileContent = Files.lines(Paths.get("D:\\sample.txt"))){
			fileContent.forEach(System.err::println);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void serializeObject() throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = null ;
		ObjectOutputStream oos = null;
		FileInputStream fis = null ;
		ObjectInputStream ois = null ;
		try {
			List<Student> list = getStudentList();
			Student s = new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122);
			 fos = new FileOutputStream("D:\\student.txt");
			 oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			
			 fis = new FileInputStream("D:\\student.txt");
			 ois = new ObjectInputStream(fis);
			List<Student> list2 =  (List<Student>) ois.readObject();
			System.out.println(list2);
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			fos.close();
			oos.close();
			fis.close();
			ois.close();
		}
	
	}
	
	private static void practiceProblemsWithStudents() throws IOException {
		List<Student> list = getStudentList();
		
		//System.out.println(list);
		//comparator
		//Collections.sort(list,(obj1,obj2) -> Integer.compare(obj1.getAge(), obj2.getAge()));
		//System.out.println(list);
		
		//1- Find list of students whose first name starts with alphabet A
		List<Student> filterList1 = list.stream().filter(student -> student.getFirstName().startsWith("A")).collect(Collectors.toList());
		System.out.println("Filter by Name");
		filterList1.forEach(System.out::println);
		
		
		//2- Group The Student By Department Names
		Map<String,List<Student>> grpByDepartments = list.stream().collect(Collectors.groupingBy(Student::getCity));
		System.out.println("Group By department");
		System.out.println(grpByDepartments);
		
		
		//3- Find the total count of student using stream
		long count = list.stream().count();
		System.out.println("Count of Students :"+count);
		
		
		//4- Find the max age of student
		int maxAge = list.stream().mapToInt(st -> st.getAge()).max().getAsInt(); 
		System.out.println("Max age of students");
		System.out.println(maxAge);
		Student maxAgeStudent = list.stream().min((s1,s2)-> s1.getAge()<s2.getAge()?-1:1).get();
		System.out.println("max Age Student "+ maxAgeStudent);
		
		list.stream().map(s -> s.getFirstName().toUpperCase()).toList();
		
		
		//flatMap
		System.out.println("FlatMap");
		 List<List<String>> Names = Arrays.asList(Arrays.asList("Saket", "Trevor"), Arrays.asList("John","Michael"),
				  Arrays.asList("Shawn", "Franklin"), Arrays.asList("Johnty", "Sean"));
		 Names.stream().flatMap(firstname -> firstname.stream()).map(String::toUpperCase).forEach(System.out::println);
		
		
		 //iterate
		 System.out.println("iterate");
		 System.out.println(IntStream.range(2, 10).sum());
		 IntStream.range(2, 10).filter(num->num%2 !=0).forEach(System.out::println);
		 
		 Stream.iterate(2, c->c+1)
		       .filter(number->number%2==0)
		       .limit(5)
		       .forEach(System.out::println);


		//5- Find all departments names
		List<String> departments = list.stream().map(Student::getDepartmantName).distinct().collect(Collectors.toList());
		System.out.println("All Departments names");
		System.out.println(departments);
		
		//6- Find the count of student in each department
		Map<String,Long> studentCountBydepartment = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()));
		System.out.println("count of student in each department");
		System.out.println(studentCountBydepartment);
		
		//Which department has max students
		Optional<Entry<String, Long>> maxDepartmentCount = list.stream()
				                                               .collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()))
				                                               .entrySet().stream().max(Map.Entry.comparingByValue());
		System.out.println("In which department max number of students studying");
		System.out.println(maxDepartmentCount.get().getKey() +":"+maxDepartmentCount.get().getValue()+"\n");
		
		//7- Find the list of students whose age is less than 30
		System.out.println("List of students who has age under 30");
		list.stream().filter(std -> std.getAge() < 30).map(std ->std.getFirstName()).toList().forEach(System.out::println);
		
		//8- Find the list of students whose rank is in between 50 and 100
		list.stream().filter(std -> std.getRank() > 50 && std.getRank()<100).collect(Collectors.toList()).forEach(System.out::println);
		
		//9- Find the average age of male and female students
		Map<String,Double> avgAgeOfMaleAndFemale = list.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));
		System.out.println("The average age of male and female students");
		System.out.println(avgAgeOfMaleAndFemale);
		
		//10- Find the department who is having maximum number of students
		System.out.println("In which department max number of students studying");
		System.out.println(list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
		
		//11- Find the Students who stays in Delhi and sort them by their names
		System.out.println("Students who's live in delhi and Sorted by their names");
		list.stream().filter(std -> std.getCity().equals("Delhi")).sorted((std1,std2) -> std1.getFirstName().compareToIgnoreCase(std2.getFirstName())).forEach(System.out::println);
		
		//12- Find the average rank in all departments
		Map<String,Double> avgRankInAllDep =  list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingInt(Student::getRank)));
        System.out.println("the average rank in all departments");
		System.out.println(avgRankInAllDep+"\n");
		
		//13- Find the highest rank in each department
		Map<String, Optional<Student>> highestRankInEachDepartment = list.stream()
				                                                    .collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.maxBy(Comparator.comparing(Student::getRank))));
		
				
		System.out.println("highest rank in each department");
		System.out.println(highestRankInEachDepartment+"\n");
		
		//14- Find the list of students and sort them by their rank
		System.out.println("Sorted based on rank");
		list.stream().sorted(Comparator.comparing(Student::getRank)).forEach(System.out::println);
		System.out.println();

		//15- Find the student who has second rank
		Student student = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
		
		
		//Write a Java 8 program to find the second highest number in a list of integers.
		List<Integer> intList  = Arrays.asList(3,4,2,5,6,7,1);
		Optional<Integer> secondLargest = intList.stream().sorted((a,b)-> b.compareTo(a)).skip(1).findFirst();
		System.out.println("SecondLargest "+secondLargest.orElseGet(()->0));
		
		System.out.println("Duplicate Values \n");
		Set<Integer> dupList = new HashSet<>();
		intList.stream().filter(n -> !dupList.add(n)).collect(Collectors.toList()).forEach(System.out::println);
		
		
		System.out.println("Frequency of elems \n");
		Set<Integer> dupList2 = intList.stream().filter(val -> Collections.frequency(intList, val)>1).collect(Collectors.toSet());

		System.out.println(dupList2);
		
		//Write a Java 8 program to remove duplicates from a list of integers.
		List<Integer> distinctList = intList.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct Values");
		System.out.println(distinctList);
		
		//Write a Java 8 program to partition a list of strings into two lists based on their length (greater than 3 characters).
		List < String > companies = Arrays.asList("meta","apple","amazon","netflix","google","uber","snapshot","instagram","ola");
		Map<Boolean,List<String>> partionedList = companies.stream().collect(Collectors.partitioningBy(c -> c.length()>3));
		System.out.println("partitioningBy length of string "+partionedList);
		System.out.println("name len greater than 5 "+companies.stream()
		                                              .filter(str -> str.length()>5).count());
		
		List<String[]> data = new ArrayList<>();
        data.add(new String[]{"ID", "Name", "Age", "Email"});
        
        System.out.println("Count occurrence of given char");
        String str = "geeksforgeeks";
        char findingChar = 'e';
        
        long occurenccount = str.chars().filter(strs -> strs ==findingChar).count();
        System.out.println("Occurence count of given char :"+occurenccount);
        
        
        //occurence of each chars
        Map<String,Long> charOccurence = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        Map<String,Long> charyOccurence = str.chars().mapToObj(String::valueOf).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("charOccurence : "+charyOccurence);

        List<Path> files =  Files.walk(Paths.get("D:\\APP-CATALOG\\BUG\\BUG_9487_2024 - While searching in tag master advance search facing an exception\\DEV")).map(Path::normalize).filter(Files::isRegularFile)
        .filter(path -> path.getFileName().toString().endsWith(".txt")).collect(Collectors.toList());
        
        
        //count of student age
        System.out.println(list.stream().reduce(0,(sum,students)->sum+students.getAge(),Integer::sum));
        
        //find max using comparator
        System.out.println(intList.stream().max((num1,num2)->num1-num2).get());
        
        
        //find max using reduce
        System.out.println(intList.stream().reduce(Math::max).get());
        
        
        List<String> names = Arrays.asList("karthick","akash",null,"akash");
        names.stream().filter(Objects::nonNull).map(String::toUpperCase).forEach(System.out::println);
        
       // System.out.println(names.stream().collect(Collectors.toMap(Function.identity(), name->name.length(),(name1,name2)->name2)));
        String ab = null;
        
        Optional.ofNullable(ab).map(String::toUpperCase).ifPresent(System.out::println);    
        
        //find frequency of each chars
        Map<String,Long> frequency = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(frequency);
        
        //sum of first 10 nums
        long sum = IntStream.rangeClosed(1, 10).reduce(0,Integer::sum);
        System.err.println(sum);
        
        
        Integer[] arr1 = new Integer[] { 1, 9, 8, 7, 7, 8, 9 };
        Arrays.asList(arr1).stream().distinct().toList();
        
        List<Integer> avg = new ArrayList<>(Arrays.asList(1,2,3));
        
        
        
        //first letter capitalize
        List<String> firstLetterCapitaliZed = companies.stream().map(n -> n.substring(0,1).toUpperCase().concat(n.substring(1))).collect(Collectors.toList());
        System.out.println(firstLetterCapitaliZed); 
        
        //last letter capitalized
        List<String> lastLetterCapitaliZed = companies.stream().map(n -> n.substring(0,n.length()-1)
        		                                                          .concat(n.substring(n.length()-1).toUpperCase()))
        		                                               .collect(Collectors.toList());
        
        System.out.println(lastLetterCapitaliZed);
        
        
        int nums = 12345;
        int sumOfInt = String.valueOf(nums).chars().map(Character::getNumericValue).sum();
        System.out.println(sumOfInt);
        
        
        //to get duplicates nums
        System.out.println("duplicate nums from list");
        List<Integer> duplicateNums =  Arrays.asList(arr1).stream()
        		                                          .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                                                          .entrySet()
                                                          .stream()
                                                          .filter(map -> map.getValue()>1)
                                                          .map(map -> map.getKey()).toList();
        System.out.println(duplicateNums);
        
        
                      
	}
	
	public static List<Student> getStudentList() {
		return Arrays.asList(
			    new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
			    new Student(2, "Pulkit", "Singh", 57, "Male", "Computer Engineering", 2018, "Delhi", 67),
			    new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
			    new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
			    new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
			    new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
			    new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
			    new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
			    new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
			    new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98),
	            new Student(2, "Karthick", "kannan", 56, "Male", "Computer Engineering", 2018, "Delhi", 67));
	}

	public static void practiceProblems() {
		
		//findFirst
		Stream<String> listStream = Stream.of("amazon","uber","zoho","apple");
		System.out.println("FindFirst");
		System.out.println(listStream.filter(val -> val.startsWith("a")).findFirst().orElseGet(null));
		
		//removeDuplicatesElements
		 List < Integer > nums = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);
		 List <Integer> distinctList =  nums.stream().distinct().collect(Collectors.toList());
		 distinctList.forEach(System.out::println);
		 
	  //Count Strings Starting with Specific Letter using Streams
		List < String > colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
		long count = colors.stream().filter(color -> color.startsWith(String.valueOf('B'))).count();
		System.out.println("Count of string starts with particular char :"+ count);
		
		
	//Sort ascending and descending
	 System.out.println("Ascending order");
	 colors.stream().sorted().forEach(System.out::println);
	 
	 System.out.println("Descending order");
	 colors.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	 
	 //genZcareer stream interview question
	 List<Integer> numList = Arrays.asList(2,5,1,2,76,89,45,3,21);
	 
	 System.out.println("sum of odd numbers");
	 System.out.println(numList.stream().filter(num -> num%2 !=0).map(n -> n*n).reduce(Integer::sum));
	}

	public static void flatMap() {
		List<List<Integer>> nestedList = Arrays.asList(
				                   			Arrays.asList(45,1,78,2),
				                   			Arrays.asList(1,43,12,56,89,1,11,20),
				                   			Arrays.asList(1,43,12,56,89,1,11,20),
				                   			Arrays.asList(10,16,72,39,71,40)
				                         );
		System.out.println("even list from nested list"+ nestedList.stream().flatMap(List::stream).filter(num -> num%2 ==0).toList());
		
	} 
	
	public static void convertStrToInt() {
		List<String> strList = Arrays.asList("6","a","78","jgy");
		
		List<Integer> numList = strList.stream().map( n -> {
							try {
								return Integer.parseInt(n);
							}catch (Exception e) {
								return null;
							}
		                  }
				         ).filter(i -> i!=null)
		                  .toList();
		numList.forEach(n -> System.out.println(n +" "));
	}
	
	public static void convertStrToIntApproach2() {
		List<String> strList = Arrays.asList("6","a","78","jgy");
		
		List<Integer> numList =  strList.stream().map(n ->{
								try {
									return Optional.ofNullable(Integer.valueOf(n));
								} catch (Exception e) {
									return Optional.<Integer>empty();	
								}
	                      	}
				         ).filter(Optional::isPresent)
		                  .map(Optional::get)
		                  .toList();
		numList.forEach(n -> System.out.println(n+" "));
	}
}
