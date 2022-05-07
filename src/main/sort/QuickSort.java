// https://www.daleseo.com/sort-quick/ 참고
package main.sort;

import java.util.*;

public class QuickSort {
	public static void quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		int mid = partition(arr, low, high);
		System.out.println("mid:" + mid);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
		sort(arr, low, mid - 1);
		sort(arr, mid, high);

	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[(low + high) / 2];
		System.out.println(low + " " + high + " " + (low + high) / 2 + " " + pivot);
		while (low <= high) {
			while (arr[low] < pivot) {
				low++;
			}
			while (pivot < arr[high]) {
				high--;
			}
			if (low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		return low;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] testCase = new int[] { 10, 9, 8, 7, 6 ,1, 2, 3, 4, 5 };
		quickSort(testCase);
		System.out.println("최종");
		for (int i = 0; i < testCase.length; i++) {
			System.out.print(testCase[i] + " ");
		}
	}
}
