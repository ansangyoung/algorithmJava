// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// 1249. Minimum Remove to Make Valid Parentheses
// https://github.com/JesusJoey/leetcode/blob/master/bloomberg/1249.%20Minimum%20Remove%20to%20Make%20Valid%20Parentheses.java 참고
package stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
    	String answer = "";
    	int openCnt = 0;
    	int closeCnt = 0;
    	int sLen = s.length();
    	for(int i = 0; i < sLen; i++) {
    		if(s.charAt(i) == ')') {
    			closeCnt++;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (char c: s.toCharArray()) {
    		 if (c == '(') {
    			 if (openCnt == closeCnt) {	// 열린괄호의 시점이, 총 닫힌괄호의 개수를 넘는 순간은 제외
    				 continue;
    			 }
    			 openCnt++;
    		 } else if (c == ')') {
    			 closeCnt--;
    			 if (openCnt == 0) {	    // 닫힌괄호의 개수가, 누적한 열린괄호의 개수를 초과하는 순간은 제외
    				 continue;
    			 }
    			 openCnt--; 
    		 }
    		 sb.append(c);
    	}
    	answer = sb.toString();
//System.out.println("answer:" + answer);
		return answer;
    }
}

public class stack1249 {
	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		
		Solution soultion = new Solution();
		soultion.minRemoveToMakeValid(s);	// "lee(t(c)o)de" || "lee(t(co)de)" || "lee(t(c)ode)"
		
		s = "a)b(c)d";
		soultion.minRemoveToMakeValid(s);	// "ab(c)d"
		
		s = "))((";
		soultion.minRemoveToMakeValid(s);	// ""
		
		s = "(a(b(c)d)";
		soultion.minRemoveToMakeValid(s);	// "a(b(c)d)"
	}
}