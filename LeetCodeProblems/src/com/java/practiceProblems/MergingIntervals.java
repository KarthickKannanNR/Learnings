package com.java.practiceProblems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingIntervals {

	public static int[][] mergeWithEffecientApproach(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}

		// Step 1: Sort intervals based on start time
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		List<int[]> merged = new ArrayList<>();

		// Step 2: Iterate through intervals
		int[] current = intervals[0]; // Start with first interval
		merged.add(current);

		for (int[] next : intervals) {
			int currentEnd = current[1];
			int nextStart = next[0];
			int nextEnd = next[1];

			if (currentEnd >= nextStart) {
				// Overlapping intervals → merge
				current[1] = Math.max(currentEnd, nextEnd);
			} else {
				// No overlap → add new interval
				current = next;
				merged.add(current);
			}
		}

		// Convert List<int[]> to int[][]
		return merged.toArray(new int[merged.size()][]);
	}

	public static void main(String[] args) {
		int[][] intervals = { { 9, 4 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		effecientApproach(intervals);
	}

	public static void effecientApproach(int[][] intervals) {
		printIntervals(mergeWithEffecientApproach(intervals));
	}

	public static void bruteForceApproach(int[][] intervals) {
		printIntervals(mergeWithBruteApproach(intervals));
	}

	private static int[][] mergeWithBruteApproach(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}

		boolean merged = true;
		List<int[]> result = new ArrayList<>(Arrays.asList(intervals));

		while (merged) {
			merged = false;
			List<int[]> temp = new ArrayList<>();
			boolean[] mergedFlags = new boolean[result.size()];

			for (int i = 0; i < result.size(); i++) {
				if (mergedFlags[i])
					continue; // Skip already merged intervals

				int[] current = result.get(i);
				boolean isMerged = false;

				for (int j = 0; j < result.size(); j++) {
					if (i != j && !mergedFlags[j]) {
						int[] next = result.get(j);

						// Check if they overlap
						if (current[1] >= next[0] && next[1] >= current[0]) {
							// Merge intervals
							current[0] = Math.min(current[0], next[0]);
							current[1] = Math.max(current[1], next[1]);
							mergedFlags[j] = true;
							isMerged = true;
						}
					}
				}
				temp.add(current);
				merged = merged || isMerged;
			}

			result = temp;
		}
		return result.toArray(new int[result.size()][]);
	}

	private static int[][] bruteForceApp(int[][] intervals) {
		int start, end = 0;
		int arr[][] = intervals;
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals.length; j++) {
				start = arr[i][j];
				end = arr[i][1];
			}
		}

		return null;
	}

	public static void printIntervals(int[][] mergedIntervals) {
		Arrays.stream(mergedIntervals)           
        .map(Arrays::toString)            
        .forEach(System.out::println);   
	}

	public static void findAnagram() {
		String s1 = "tu   b ";
		String s2 = "b ut";

		String sortedS1 = Stream.of(s1.split("")).sorted().collect(Collectors.joining());
		String sortedS2 = Stream.of(s1.split("")).sorted().collect(Collectors.joining());
		System.out.println(sortedS1.equals(sortedS2));
	}

}
