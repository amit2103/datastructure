package com.amit.algos;

import java.util.Random;

public class QuickSelect {
	private static final Random random = new Random();
	private QuickSelect() {
	}
	
	public static int select(int[] numbers, int index) {
		return select(numbers, 0, numbers.length - 1, index);
	}
	private static int select(int[] numbers, int low, int high, int index) {
		if (high == low) return numbers[index];
		int pivotIndex = getRandomIndex(low, high);
		int pivotPosition = QuickSort.partition(numbers, low, high, pivotIndex);
		if (pivotPosition == index) return numbers[index];
		if (index < pivotPosition) {
			return select(numbers, low, pivotPosition - 1, index);
		} else {
			return select(numbers, pivotPosition + 1, high, index);
		}
	}
	
	public static Comparable select(Comparable[] numbers, int index) {
		return select(numbers, 0, numbers.length - 1, index);
	}
	private static Comparable select(Comparable[] array, int low, int high, int index) {
		if (high == low) return array[index];
		int pivotIndex = getRandomIndex(low, high);
		int pivotPosition = QuickSort.partition(array, low, high, pivotIndex);
		if (pivotPosition == index) return array[index];
		if (index < pivotPosition) {
			return select(array, low, pivotPosition - 1, index);
		} else {
			return select(array, pivotPosition + 1, high, index);
		}
	}
	/**
	 * Helper methods
	 */
	private static int getRandomIndex(int low, int high) {
		return random.nextInt(high - low + 1) + low;
	}
}
