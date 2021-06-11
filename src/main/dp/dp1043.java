// https://leetcode.com/problems/partition-array-for-maximum-sum/
// 1043. Partition Array for Maximum Sum
// https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/290863/JavaC%2B%2BPython-DP 참조
package main.dp;

import java.util.ArrayList;

public class dp1043 {
	public static int maxSumAfterPartitioning(int[] arr, int k) {
		int res = 0;

		ArrayList<Integer> dp = new ArrayList<Integer>();
		int arrLen = arr.length;
		// dp.get(i) == arr(i - 1)까지 합의 최댓값
		for (int i = 0; i <= arrLen; i++) {
			dp.add(0);
		}

		for (int i = 1; i <= arrLen; i++) {
			int kRangePartMax = 0;
			int accumulateMax = 0;
			for (int j = 1; j <= k; j++) {
				if (i - j >= 0) {
					kRangePartMax = Math.max(kRangePartMax, arr[i - j]);
					accumulateMax = Math.max(accumulateMax, dp.get(i - j) + kRangePartMax * j);
				}
			}
			dp.set(i, accumulateMax);
		}
		res = dp.get(arrLen);
System.out.println("res:" + res);
		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;
		maxSumAfterPartitioning(arr, k); // 84

		arr = new int[] { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 };
		k = 4;
		maxSumAfterPartitioning(arr, k); // 83

		arr = new int[] { 1 };
		k = 1;
		maxSumAfterPartitioning(arr, k); // 1
	}
}