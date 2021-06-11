// https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
// 1638. Count Substrings That Differ by One Character
// https://kickstart.best/1638-count-substrings-that-differ-by-one-character/ 참고
package main.dp;

public class dp1638 {
	static int countSubstrings(String s, String t) {
		int[][] dp1 = new int[105][105];
		int[][] dp2 = new int[105][105];

		int sLen = s.length();
		int tLen = t.length();
		s = "#" + s + "#";
		t = "#" + t + "#";

		// left to right
		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= tLen; j++) {
				if (s.charAt(i) == t.charAt(j)) {
					dp1[i][j] = dp1[i - 1][j - 1] + 1;
				} else {
					dp1[i][j] = 0;
				}
			}
		}

		// right to left
		for (int i = sLen; i >= 1; i--) {
			for (int j = tLen; j >= 1; j--) {
				if (s.charAt(i) == t.charAt(j)) {
					dp2[i][j] = dp2[i + 1][j + 1] + 1;
				} else {
					dp2[i][j] = 0;
				}
			}
		}

		int ret = 0;
		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= tLen; j++) {
				if (s.charAt(i) != t.charAt(j)) {
					ret += (dp1[i - 1][j - 1] + 1) * (dp2[i + 1][j + 1] + 1);
				}
			}
		}
		System.out.println("ret:" + ret);
		return ret;
	}

	public static void main(String[] args) {
		String s = "aba";
		String t = "baba";
		countSubstrings(s, t); // 6

		s = "ab";
		t = "bb";
		countSubstrings(s, t); // 3

		s = "a";
		t = "a";
		countSubstrings(s, t); // 0

		s = "abe";
		t = "bbc";
		countSubstrings(s, t); // 10
	}
}