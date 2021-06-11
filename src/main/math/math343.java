// https://leetcode.com/problems/integer-break/
// 343. Integer Break
package main.math;

import java.util.*;

public class math343 {
	public static int integerBreak(int n) {
		int res = 1;
		int[] exceptCase = new int[] { 0, 1, 1, 2, 4 };

		if (n > 3) {
			res *= Math.pow(3, n / 3);
			if (n % 3 == 1) {
				res = (res / 3) * exceptCase[4];
			} else if (n % 3 == 2) {
				res *= n % 3;
			}
		} else {
			res *= exceptCase[n];
		}
//System.out.println("res:" + res);
		return res;
	}

	public static void main(String[] args) {
		int n = 2;
		integerBreak(n); // 1

		n = 10;
		integerBreak(n); // 36

		n = 5;
		integerBreak(n); // 6
	}
}