// https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
// 1247. Minimum Swaps to Make Strings Equal
// https://github.com/cherryljr/LeetCode/blob/master/Minimum%20Swaps%20to%20Make%20Strings%20Equal.java 참고
package string;

class Solution {
    public int minimumSwap(String s1, String s2) {
        int answer = -1;
        int s1Len = s1.length();
        int s2Len = s2.length();
        
        if(s1Len == s2Len) {
        	int diffX = 0;
        	int diffY = 0;
        	for(int i = 0; i < s1Len; i++) {
        		if (s1.charAt(i) != s2.charAt(i)) {
        			if (s1.charAt(i) == 'x') {
        				diffX += 1;
        			} else {
        				diffY += 1;
        			}
        		}
        	}
        	
        	if((diffX + diffY) % 2 == 0) {
        		answer = (diffX + 1) / 2 + (diffY + 1) / 2;	// 00:11, 01:10 경우를 고려한 수식
        	}
        }
//System.out.println("answer:" + answer);
		return answer;
    }
}

public class string1247 {
	public static void main(String[] args) {
		String s1 = "xx";
		String s2 = "yy";
		
		Solution soultion = new Solution();
		soultion.minimumSwap(s1, s2);	// 1
		
		s1 = "xy";
		s2 = "yx";
		soultion.minimumSwap(s1, s2);	// 2
		
		s1 = "xx";
		s2 = "xy";
		soultion.minimumSwap(s1, s2);	// -1
		
		s1 = "xxyyxyxyxx";
		s2 = "xyyxyxxxyx";
		soultion.minimumSwap(s1, s2);	// 4
	}
}