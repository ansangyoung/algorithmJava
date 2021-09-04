// https://leetcode.com/problems/integer-break/
// 343. Integer Break
package main.math;

import java.util.*;

public class math343 {
	public static int integerBreak(int n) {
		int[] exceptCase = new int[] { 0, 1, 1, 2, 4 };
        
        if(n <= 3) return exceptCase[n];
        
        int res = 1 * (int)Math.pow(3, n / 3);
        int nQuot = n % 3;
        if (nQuot == 1) {
            res = (res / 3) * exceptCase[4];
        } else if (nQuot == 2) {
            res *= nQuot;
        }
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