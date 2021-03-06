package com.amit.algos;

import java.util.Random;
public class QuickSort {
	private static final Random random = new Random();
	private static final int INSERTION_THRESHOLD = 47;
	private QuickSort() {
	}
	/**
	 * Sorts the entire array of integers.
	 */
	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	/**
	 * Sorts the array of integers from the low index to
	 * the high one (both included).
	 *
	 * @param a
	 * @param low
	 * @param high
	 */
	public static void sort(int[] a, int low, int high) {
		int pivotIndex = getRandomIndex(low, high);
		int separationIndex = partition(a, low, high, pivotIndex);
		sort(a, low, separationIndex - 1);
		sort(a, separationIndex + 1, high);
	}
	/**
	 * Partitions the array from the low index to high
	 * index (both included) around the pivot at the
	 * given pivot index.
	 *
	 * @param a
	 * @param low
	 * @param high
	 * @param pivotIndex
	 */
	public static int partition(int[] a, int low, int high, int pivotIndex) {
		int pivot = a[pivotIndex];
		swap(a, pivotIndex, high);
		int storeIndex = low;
		for (int i = low; i < high; i++) {
			if (pivot > a[i]) {
				swap(a, i, storeIndex++);
			}
		}
		swap(a, storeIndex, high);
		return storeIndex;
	}
	/**
	 * Sorts the entire array of comparable objects.
	 */
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	/**
	 * Sorts the array of comparable objects from the low index to
	 * the high one (both included).
	 * @param <T>
	 *
	 * @param a
	 * @param low
	 * @param high
	 */
	public static <T> void sort(Comparable<T>[] a, int low, int high) {
		
		int pivotIndex = getRandomIndex(low, high);
		int separationIndex = partition(a, low, high, pivotIndex);
		sort(a, low, separationIndex - 1);
		sort(a, separationIndex + 1, high);
	}
	/**
	 * Partitions the array from the low index to high
	 * index (both included) around the pivot at the
	 * given pivot index.
	 *
	 * @param a
	 * @param low
	 * @param high
	 * @param pivotIndex
	 */
	public static int partition(Comparable[] a, int low, int high, int pivotIndex) {
		Comparable pivot = a[pivotIndex];
		swap(a, pivotIndex, high);
		int storeIndex = low;
		for (int i = low; i < high; i++) {
			if (pivot.compareTo(a[i]) > 0) {
				swap(a, i, storeIndex++);
			}
		}
		swap(a, storeIndex, high);
		return storeIndex;
	}
	private static int getRandomIndex(int low, int high) {
		return random.nextInt(high - low + 1) + low;
	}
	private static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	private static void swap(Comparable[] a, int index1, int index2) {
		Comparable temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	public static void printArray(int[] a) {
		System.out.println();
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
	public static void main(String[] args) {
		int[] abc = new int[]{7, 6, 3, 4, 1, 6, 5, 2, 8};
		assertArrayIsSorted(abc);
		QuickSort.printArray(abc);
		QuickSort.sort(abc);
	}
	public static void assertArrayIsSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) throw new Error("Doesn't work!");
		}
	}
}
