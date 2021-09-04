// https://leetcode.com/problems/word-break/
// 139. Word Break
// https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419378/JavaC%2B%2BPython-Sliding-Window-atMost(K)-atMost(K-1) 참고
package main.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class set139 {
	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>(wordDict);
		int sLen = s.length();
		boolean[] dp = new boolean[sLen + 1];
		dp[0] = true;
		for (int i = 1; i <= sLen; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
//System.out.println("dp[sLen]:" + dp[sLen]);
		return dp[sLen];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		wordBreak(s, wordDict);
	}
}