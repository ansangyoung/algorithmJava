// https://programmers.co.kr/learn/courses/30/lessons/70128
// 내적
package list;
import java.util.*;

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int aLen = a.length;
        for(int i = 0; i < aLen; i++) {
        	answer += a[i] * b[i];
        }
//System.out.println("answer:" + answer);
        return answer;
    }
}

public class list70128 {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		int[] b = {-3, -1, 0, 2};
		
		Solution soultion = new Solution();
		soultion.solution(a, b); // 3
		
		a = new int[] {-1, 0, 1};
		b = new int[] {1, 0, -1};
		soultion.solution(a, b); // -2
	}
}
