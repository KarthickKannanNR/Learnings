package com.java.practiceProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProblemSolving {
	static int[] arr = { 11, 20, 4, 1, 5, 7, 3, 9, 2, 0, 1 };
	static String name = "deified";
	public static void main(String[] args) {
//		two sum
//		int nums[] = {7,2,13,11,8};
//		System.out.println(twoSum(nums, 24)); 

//		median
//      System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
//		
//		int heights[] = new int[]{150,165,170};
//		String names[] = new String[]{"Mary","John","Emma"};
//		SortThePeople(names,heights);
//		reverseAnArray(1,new int[] {4,1,5,7,3,9,2});
//		System.out.println(palindromeRecursion(1));
//		System.out.println(findNthFibonacci(6));
//		findCharOccurrence(); 
//		findMin();
//		linearSort();

//		System.out.println(Arrays.toString(arr));
//		mergeSort(arr,0,arr.length-1);
//		System.out.println(Arrays.toString(arr));

//		List<Integer> arr = Arrays.asList(new Integer[]{4, 6, 2, 5, 7, 9, 1, 3}); 
//		quickSort(arr);

//		secondLargest();
//		isArraySorted();
//		removeDuplicates();
//		rotateArrByOne();

//		rotateArrayByKElm();
//		rotateArrayByKElmOptimised();
//		moveNonZeroNumToLast();
//		union();
//		interSectionOfTwoArrays();
//		findMIssiongNumber();
//		maxConsecutiveNums();
//		nunberAppearsOnce();
//		palindrome();
//		romanToInte2();
//		System.out.println(longestCommonPrefix(new String[] {"flower","flow","karthick"}));
//		System.out.println(findfactorial(5));
//		reverseNum();
//		armstrongNum();
//		findNumOfDigits();
        String str = "abc";
        HashSet<String> set = new HashSet<>();
        generatePermutations(str.toCharArray(),0,set);
        System.out.println(set);

	}
	static void generatePermutations(char[] chars, int index,HashSet<String> set) {
        if (index == chars.length - 1) { 
        	set.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);  
            generatePermutations(chars, index + 1,set);  
            swap(chars, i, index);  
        }
    }
	
	static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
	public static int[] twoSum(int[] nums, int target) {

//    	int result[] = new int[2];
//    	boolean flag = false;
//    	for(int i=0;i<nums.length;i++) {
//    		result[0] = i;
//    		for(int j=i+1;j<nums.length;j++) {
//    			if( nums[i]+nums[j] == target) {
//    				result[1] = j;
//    				flag = true;
//    				break;
//    			}
//    		}
//    		if(flag)break;
//    	}
//		return result;

//     Effective Solution Time Complexity: O(n) Space Complexity: O(n)

		HashMap<Integer, Integer> arrValMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer requiredNum = (Integer) (target - nums[i]);
			if (arrValMap.containsKey(requiredNum)) {
				int returnArr[] = { arrValMap.get(requiredNum), i };
				return returnArr;
			}
			arrValMap.put(nums[i], i);
		}
		return null;
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int i = 0;
		int j = 0;
		int c = 0;
		int nums3[] = new int[nums1.length + nums2.length];
		double result = 0.0;
		if (Arrays.stream(nums1).sum() > 0 || Arrays.stream(nums2).sum() > 0) {
			while (i < nums1.length) {
				nums3[c++] = nums1[i++];
			}
			while (j < nums2.length) {
				nums3[c++] = nums2[j++];
			}
			Arrays.sort(nums3);
			if (nums3.length % 2 == 0) {
				result = (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2 + 0.5;
			} else {
				result = nums3[nums3.length / 2];
			}
		}
		return result;
	}

	// 2418 - Easy
	public static String[] SortThePeople(String[] names, int[] heights) {

		int tempvar = 0;
		String returnArr[] = new String[names.length];
		int orgHeightArr[] = heights.clone();
		// if n = 5
		// timeComplexity = O(n) + O(n2) + O(n) + O(n)
		// timeComplexity = O(n2)
		for (int i = 0; i < heights.length - 1; i++) {
			// 1 + 1 + 1 + 1+ 1
			for (int j = 0; j < heights.length - 1; j++) {
				// 5 + 5 + 5 + 5 + 5
				if (heights[j] < heights[j + 1]) {
					tempvar = heights[j + 1];
					heights[j + 1] = heights[j];
					heights[j] = tempvar;
				}
			}
		}
		for (int k = 0; k < heights.length; k++) {
			for (int j = 0; j < heights.length; j++) {
				if (heights[k] == orgHeightArr[j]) {
					returnArr[k] = names[j];
					break;
				}
			}
		}

		return returnArr;

	}

	public static void patternPrint() {
		int n = 5;
		System.out.println(Math.round(Math.log10(7789)));
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			for (int k = 0; k < n - i - 1; k++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void reverseNum() {
		int n = 7789;
		int rem;
		int revNum = 0;
		while (n > 0) {
			rem = n % 10;
			n = n / 10;
			revNum = revNum * 10 + rem;
		}
		System.out.println(revNum);
	}

	public static void palindrome() {
		int n = 121;
		int rem;
		int revNum = 0;
		int n2 = n;
		while (n > 0) {
			rem = n % 10;
			n = n / 10;
			revNum = revNum * 10 + rem;
		}
		System.out.println(revNum + " " + n2);
		System.out.println(n2 == revNum);
	}

	public static void armstrongNum() {
		int sum = 0;
		int n = 1634;
		int rem = 0;
		int dup = n;
		while (n > 0) {
			rem = (n % 10);
			sum += Math.pow(rem, String.valueOf(dup).length());
			n = n / 10;
		}
		System.out.println(sum);
		System.out.println(sum == dup);
	}

	public static void divisibleNumbersOfN() {
		// O(sqrt(n))
		int n = 25;
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				nums.add(i);
			}
			if (n % i == 0 && n / i != i) {
				nums.add(n / i);

			}
		}
		Collections.sort(nums);
		System.out.println(nums);
	}

	public static void gcdHcf() {
		int a = 9;
		int b = 12;
		int hcf = 0;
		for (int i = 1; i <= (a > b ? b : a); i++) {
			if (a % i == 0 && b % i == 0) {
				System.out.println(i);
				hcf = i;
			}
		}
		System.out.println(hcf);
	}

	public static void recursoin(int i, int n) {
		if (n < i) {
			return;
		}
		System.out.println(n);
		recursoin(i, n - 1);
	}

	public static void recursoinBackTrack(int i, int n) {
		if (i > n) {
			return;
		}
		recursoinBackTrack(i + 1, n);
		System.out.println(i);
	}

	public static void sumOfn(int i, int sum) {
		if (i < 1) {
			System.out.println(sum);
			return;
		}
		sumOfn(i - 1, sum + i);
	}

	public static int functionalRecursion(int i) {
		if (i == 0) {
			return 1;
		}
		return i * functionalRecursion(i - 1);
	}

	public static void reverseAnArray(int i, int arr[]) {
//    	int tempVar = 0;
//    	for(int i=1;i<=arr.length/2;i++) {
//    		tempVar =  arr[i-1];
//    		arr[i-1] = arr[arr.length-i];
//    		arr[arr.length-i] = tempVar;
//    	}
//    	System.out.println(Arrays.toString(arr));

		if (i > arr.length / 2) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		int tempVar = arr[i - 1];
		arr[i - 1] = arr[arr.length - i];
		arr[arr.length - i] = tempVar;
		reverseAnArray(i + 1, arr);
	}

	public static boolean palindromeRecursion(int i) {

		if (i > name.toCharArray().length / 2) {
			return true;
		}
		if (name.toCharArray()[i - 1] != name.toCharArray()[name.toCharArray().length - i]) {
			return false;
		}
		return palindromeRecursion(i + 1);
	}

	public static int findNthFibonacci(int n,String method) {
		System.out.println(method+" "+n);
		if (n <= 1) {
			return n;
		}
		return findNthFibonacci(n - 1,"method_1") + findNthFibonacci(n - 2,"method_2");
	}
	
	public static int findFibonacci(int i) {
		if(i <= 1) return i;
		return findFibonacci(i-1) + findFibonacci(i-2);
	}

	public static void findNOccurrence() {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		HashMap<Integer, Integer> occurCount = new HashMap<>();
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
			if (occurCount.get(arr[i]) != null) {
				occurCount.put(arr[i], occurCount.get(arr[i]).intValue() + 1);
			} else {
				occurCount.put(arr[i], 1);
			}
		}
		System.out.println(occurCount);
	}

	public static void findCharOccurrence() {
		Scanner sc = new Scanner(System.in);
		String stringVal = sc.nextLine();
		int hash[] = new int[256];
		/*
		 * HashMap<String, Integer> occurCount = new HashMap<>(); for(int
		 * i=0;i<stringVal.toCharArray().length;i++) {
		 * if(occurCount.get(String.valueOf(stringVal.toCharArray()[i])) != null) {
		 * occurCount.put(String.valueOf(stringVal.toCharArray()[i]),occurCount.get(
		 * String.valueOf(stringVal.toCharArray()[i])).intValue()+1); }else {
		 * occurCount.put(String.valueOf(stringVal.toCharArray()[i]),1); } }
		 * System.out.println(occurCount);
		 */

		for (int i = 0; i < stringVal.toCharArray().length; i++) {
			hash[stringVal.toCharArray()[i]]++;
		}

		for (int i = 0; i < stringVal.toCharArray().length; i++) {
			System.out.println(hash[stringVal.toCharArray()[i]]);
		}

	}

	public static void findMin() {

		int arr[] = { 3, 78, 2, 54, 5, 12, 0, 97, 1 };
		int min, tempVar;
		for (int i = 0; i < arr.length - 1; i++) {
			min = arr[i];
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					min = arr[j];
				}
				if (min != arr[i]) {
					tempVar = arr[i];
					arr[i] = min;
					arr[j] = tempVar;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort() {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		int tempVar;
		boolean swap = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap = true;
					tempVar = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tempVar;
				}
			}
			if (!swap)
				break;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void linearSort() {
		int arr[] = { 7, 2, 5, 3, 2, 1, 8, 11, 1 };
		int temp, j;
		for (int i = 0; i <= arr.length - 1; i++) {
			j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int arr[], int low, int high) {

		if (low >= high)
			return;

		int mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		sort(arr, low, mid, high);
	}

	public static void sort(int arr[], int low, int mid, int high) {
		List<Integer> sortedArr = new ArrayList<>();
		int left = low;
		int right = mid + 1;

		while (left <= mid && right <= high) {
			if (arr[left] < arr[right]) {
				sortedArr.add(arr[left]);
				left++;
			} else {
				sortedArr.add(arr[right]);
				right++;
			}
		}
		while (left <= mid) {
			sortedArr.add(arr[left]);
			left++;
		}
		while (right <= high) {
			sortedArr.add(arr[right]);
			right++;
		}

		for (int i = low; i <= high; i++) {
			arr[i] = sortedArr.get(i - low);
		}
	}

	public static void quickSort(List<Integer> arr) {
		qs(arr, 0, arr.size() - 1);
		System.out.println(arr);
	}

	public static void qs(List<Integer> arr, int low, int high) {

		if (low < high) {
			int pIndex = partionIndex(arr, low, high);
			qs(arr, low, pIndex - 1);
			qs(arr, pIndex + 1, high);
		}
	}

	public static int partionIndex(List<Integer> arr, int low, int high) {
		int pivot = arr.get(low);
		int i = low;
		int j = high;

		while (i < j) {
			while (arr.get(i) <= pivot && i <= high - 1) {
				i++;
			}

			while (arr.get(j) > pivot && j >= low + 1) {
				j--;
			}
			if (i < j) {
				int temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}
		int temp = arr.get(low);
		arr.set(low, arr.get(j));
		arr.set(j, temp);
		return j;

	}

	public static void secondLargest() {
		int arr[] = { 11, 45, 75, 21, 1, 33, 56, 24, 1, 2, 55, 100 };
		int largest = arr[0], secondLargest = Integer.MIN_VALUE, smallest = arr[0], secondSmallest = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			} else if (arr[i] > secondLargest && arr[i] < largest) {
				secondLargest = arr[i];
			}
			if (arr[i] < smallest) {
				secondSmallest = smallest;
				smallest = arr[i];
			} else if (arr[i] < secondSmallest && arr[i] > smallest) {
				secondSmallest = arr[i];
			}

		}
		System.out.println("Largest : " + largest + " Second Largest " + secondLargest + " smallest: " + smallest
				+ " SecondSmallest : " + secondSmallest);
	}

	public static void isArraySorted() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		boolean sorted = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				sorted = false;
				break;
			}
		}
		System.out.println("Given array is sorted :" + sorted);
	}

	public static void removeDuplicates() {
		int arr[] = { 1, 1, 2, 2, 3, 3, 4, 44 };
		int i = 0;
		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}
		System.out.println("Without duplication the array size is " + i);
		for (int k = 0; k < i; k++) {
			System.out.print(arr[k] + " ");
		}
	}

	public static void rotateArrByOne() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = temp;
		System.out.println(Arrays.toString(arr));
	}

	public static void rotateArrayByKElm() {
		// TC = O(k) + O(n-k) + O(k) = O(n+k)
		// SC = O(k)
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = arr.length;
		int k = 10;
		if (n != k) {
			if (k > n) {
				k = k % n;
			}
			int shiftingArr[] = new int[k];

			// O(k)
			for (int i = 0; i < k; i++) {
				shiftingArr[i] = arr[i];
			}
			System.out.println(Arrays.toString(shiftingArr));

			int j = k;
			for (int i = 0; i < n - k; i++) {
				arr[i] = arr[j];
				j++;
			}
			System.out.println(Arrays.toString(arr));

			int f = 0;
			for (int i = n - k; i < n; i++) {
				arr[i] = shiftingArr[f];
				f++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void rotateArrayByKElmOptimised() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = arr.length;
		int k = 10;
		System.out.println(Arrays.toString(arr));
		if (k > n) {
			k = k % n;
			Reverse(arr, 0, k - 1);
			Reverse(arr, k, n - 1);
			Reverse(arr, 0, n - 1);
		}

		System.out.println(Arrays.toString(arr));

	}

	public static void Reverse(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void moveNonZeroNumToLast() {
		int arr[] = { 1, 2, 0, 1, 0, 4, 0 };
		int j = 0, temp;
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != 0 && arr[j] == 0) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			} else if (arr[i] == 0 && arr[j] != 0) {
				j++;
			}
		}
		System.out.println(Arrays.toString(arr));
		// TC = O(n)
		// SC = O(1)
	}

	public static void union() {
		int arr[] = { 1, 8, 2, 4, 7, 3 }, arr2[] = { 2, 6, 7, 3, 1, 5, 4, 9 };
		HashSet<Integer> uniorArr = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			uniorArr.add(arr[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			uniorArr.add(arr2[i]);
		}
		System.out.println(uniorArr);
	}

	public static void interSectionOfTwoArrays() {
		int arr[] = { 1, 2, 4, 4, 5, 7 }, arr2[] = { 2, 2, 3, 3, 5, 7, 7 };
		int i = 0;
		int j = 0;
		List<Integer> unionArr = new ArrayList<>();
		while (i < arr.length && j < arr.length) {
			if (arr[i] < arr2[j]) {
				i++;
			} else if (arr2[j] < arr[i]) {
				j++;
			} else {
				unionArr.add(arr[i]);
				i++;
				j++;
			}
		}
		System.out.println(unionArr);
		// SC = O(n1+n2)
		// TC = O(1)
	}

	public static void findMIssiongNumber() {
		int arr[] = { 1, 2, 4, 5, 6 };
		int xor1 = 0;
		int xor2 = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			xor2 = xor2 ^ arr[i];
			xor1 = xor1 ^ (i + 1);
		}
		xor1 = xor1 ^ arr.length;
		System.out.println(xor1 ^ xor2);
	}

	public static void maxConsecutiveNums() {
		int arr[] = { 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 };
		int max = 0;
		int findNum = 1, count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (findNum == arr[i]) {
				count++;
			} else {
				count = 0;
			}
			if (count > max) {
				max++;
			}
		}
		System.out.println(max);

	}

	public static void nunberAppearsOnce() {
		int arr[] = { 4, 1, 2, 1, 2 };

		/*
		 * Brute Force approach int max = arr[0]; for(int i=0;i<arr.length;i++) { max =
		 * Math.max(max, arr[i]); } int hashArr[] = new int[max+1]; for(int
		 * i=0;i<arr.length;i++) { hashArr[arr[i]]+=1; } for(int
		 * j=0;j<hashArr.length;j++) { if(hashArr[j] == 1) { System.out.println(j);
		 * break; } }
		 */

		
		
		/*
		 * HashMap<Long, Integer> countMap = new HashMap<>(); for(int
		 * i=0;i<arr.length;i++) {
		 * if(countMap.get(Long.parseLong(String.valueOf(arr[i])))!=null) {
		 * countMap.put(Long.parseLong(String.valueOf(arr[i])),countMap.get(Long.
		 * parseLong(String.valueOf(arr[i]))).intValue()+1); }else {
		 * countMap.put(Long.parseLong(String.valueOf(arr[i])),1); } }
		 * System.out.println(countMap.entrySet().stream().filter(map ->
		 * map.getValue()==1).map(Map.Entry::getKey).findFirst());
		 */

		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor = xor ^ arr[i];
		}
		System.out.println(xor);

	}
	
	public static void romanToInt() {
		String s = "LVIII";
		int count = 0;
		HashMap<Character, Integer> romanCount = new HashMap<>();
		romanCount.put('I', 1);
		romanCount.put('V', 5);
		romanCount.put('X', 10);
		romanCount.put('L', 50);
		romanCount.put('C', 100);
		romanCount.put('D', 500);
		romanCount.put('M', 1000);

		for(int i = 0;i<s.length()-1;i++) {
			if(romanCount.get(s.toCharArray()[i]) < romanCount.get(s.toCharArray()[i+1])) {
				count -= romanCount.get(s.toCharArray()[i]);
			}else {
				count += romanCount.get(s.toCharArray()[i]);
			}
		}
		System.out.println(count);
	}
	
	public static void romanToInte2() {
		String s = "MCMXCIV";
		 Map< Character, Integer> m = new HashMap<>();
	        
	        m.put('I', 1);
	        m.put('V', 5);
	        m.put('X', 10);
	        m.put('L', 50);
	        m.put('C', 100);
	        m.put('D', 500);
	        m.put('M', 1000);
	        
	        int ans = 0;
	        
	        for (int i = 0; i < s.length(); i++) {
	            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
	                ans -= m.get(s.charAt(i));
	            } else {
	                ans += m.get(s.charAt(i));
	            }
	        }
	        System.out.println(ans);
	}
	
	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0)
	      return "";

	    for (int i = 0; i < strs[0].length(); ++i)
	      for (int j = 1; j < strs.length; ++j)
	        if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
	          return strs[0].substring(0, i);

	    return strs[0];
	  }
	
	public static int findfactorial(int n) {
		if(n==0) return 1;
	    return n* findfactorial(n-1);
	}
	
	public static void findNumOfDigits() {
		int num =-65,count=0;
		if(num<0) {
			num = num*-1;
		}else if(num==0) {
			num=1;
		}
		
		while(num>0) {
			num = num/10;
			count+=1;
		}
		System.out.println(count);
	}

}
