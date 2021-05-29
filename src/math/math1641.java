// https://leetcode.com/problems/count-sorted-vowel-strings/
// 1641. Count Sorted Vowel Strings
package math;

import java.util.*;

class Solution {
    public int countVowelStrings(int n) {
    	int res = 1;
    	// n H r = n + r - 1 C r
        int r = n;
        int nr1 = 5 + r - 1;
        int iterCnt = r < nr1 - r ? r : nr1 - r;

        for(int i = 1; i <= iterCnt; i++) {
        	res *= nr1 + 1 - i;
        	res /= i;
        }
//System.out.println("res:" + res);
        return res;
    }
}

public class math1641 {
	public static void main(String[] args) {
		int n = 1;
		
		Solution soultion = new Solution();
		int result = soultion.countVowelStrings(n); // 5
		
		n = 2;
		result = soultion.countVowelStrings(n); // 15
		
		n = 33;
		result = soultion.countVowelStrings(n); // 66045
		
	}
}