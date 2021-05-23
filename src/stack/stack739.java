// https://leetcode.com/problems/daily-temperatures/
// 739. Daily Temperatures
// https://github.com/Cee/Leetcode/blob/master/739%20-%20Daily%20Temperatures.java 참고
package stack;

import java.util.Stack;

class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		int temperaturesLen = temperatures.length;
        int[] ans = new int[temperaturesLen];
        Stack<Integer> stack = new Stack();
        for (int i = temperaturesLen - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
            	stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}

public class stack739 {
	public static void main(String[] args) {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		
		Solution soultion = new Solution();
		soultion.dailyTemperatures(temperatures);	// [1, 1, 4, 2, 1, 1, 0, 0]
	}
}
