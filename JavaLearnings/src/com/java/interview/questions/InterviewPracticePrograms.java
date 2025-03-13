package com.java.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InterviewPracticePrograms {

	public static void sortBySalaryAndAge() {
		List<Employee> empList = Arrays.asList(new Employee(1, "karthick", 30000, "active"),
				new Employee(1, "ramesh", 30000, "active"), new Employee(1, "raju", 25000, "active"),
				new Employee(1, "somu", 28000, "active"), new Employee(1, "akilash", 25000, "active"));
		List<Employee> sortedEmp = empList.stream().sorted(
				Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName, Comparator.reverseOrder()))
				.collect(Collectors.toList());

		System.out.println(sortedEmp);
	}

	public static void main(String[] args) {
		longestSubStrCaller();
	}

	public static List<String> findDistinctPalindromicSubstrings(String s) {
        Set<String> result = new HashSet<>(); // Using Set to store unique values

        for (int i = 0; i < s.length(); i++) {
            countPalindromes(s, i, i, result);       // Odd-length palindromes
            countPalindromes(s, i, i + 1, result);   // Even-length palindromes
        }

        return new ArrayList<>(result); // Convert Set to List for output
    }

	private static void countPalindromes(String s, int left, int right, Set<String> result) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > 1) { // Only consider substrings of length >= 2
                result.add(s.substring(left, right + 1));
            }
            left--;
            right++;
        }
    }

	public static void longestSubStrCaller() {
		String s = "aabacbdbr";
		List<String> palindromicSubstrings = findDistinctPalindromicSubstrings(s);
		System.out.println("Palindromic Substrings: " + palindromicSubstrings);
	}

}
