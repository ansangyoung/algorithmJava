// 출처: https://yunmap.tistory.com/entry/알고리즘-Java로-구현하는-쉬운-Merge-Sort-병합-정렬-합병-정렬 [현미와 백미는 섞어먹자.] 참고
package main.sort;

public class MergeSort {
	public static int[] src;
	public static int[] tmp;
	public static int cnt = 1;
	
	public static void main(String[] args) {
		src = new int[] { 10, 9, 8, 7, 6 ,5 ,4, 3, 2, 1 };
		tmp = new int[src.length];
		mergeSort(0, src.length - 1);
		printArray(src);
	}

	public static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			int p = start;
			int q = mid + 1;
			int idx = p;
			while (p <= mid || q <= end) {
				if (end < q || (p <= mid && src[p] < src[q])) {
					tmp[idx++] = src[p++];
				} else {
					tmp[idx++] = src[q++];
				}
			}

			System.out.print(cnt++ + " 번째 수행 -> ");
			for (int i = start; i <= end; i++) {
				src[i] = tmp[i];
				System.out.print(i + ": " + src[i]);
				if(i != end) {
					System.out.print(", ");
				}
			}
			System.out.println("");
		}
	}

	public static void printArray(int[] a) {
		System.out.print("최종 결과 -> ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
