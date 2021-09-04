// https://programmers.co.kr/learn/courses/30/lessons/76501
// 음양 더하기
package main.list;
import java.util.*;
class Solution10 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int absolutesLen = absolutes.length;
        for(int i = 0; i < absolutesLen; i++) {
        	if(signs[i]) {
        		answer += absolutes[i];
        	} else {
        		answer -= absolutes[i];
        	}
        }
System.out.println("answer:" + answer);
        return answer;
    }
}

public class list76501 {
	public static void main(String[] args) {
		int[] absolutes = {4, 7, 12};
		boolean[] signs = {true, false, true};
		
		Solution10 soultion = new Solution10();
		soultion.solution(absolutes, signs); // 9
		
		absolutes = new int[] {1, 2, 3};
		signs = new boolean[] {false, false, true};
		soultion.solution(absolutes, signs); // 0
	}
}