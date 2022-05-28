// https://programmers.co.kr/learn/courses/30/lessons/12910
// 코딩테스트 연습 > 연습문제 > 나누어 떨어지는 숫자 배열
package main.list;

import java.util.ArrayList;
import java.util.Collections;

class solution12910 {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		int arrLen = arr.length;
		ArrayList<Integer> arrayToArrayList = new ArrayList<Integer>();
        
		for(int i = 0; i < arrLen; i++) {
	        if(arr[i] % divisor == 0) {
	        	arrayToArrayList.add(arr[i]);
	        }
		}
		
		if(arrayToArrayList.size() == 0) {
			arrayToArrayList.add(-1);
		}
        
		Collections.sort(arrayToArrayList);

		answer = new int[arrayToArrayList.size()];
		int i = -1;
		for(int listValue : arrayToArrayList) {
			answer[++i] = listValue;
System.out.print(answer[i] + " ");
		}
System.out.println("");
		return answer;
	}
}

public class list12910 {
	public static void main(String[] args) {
		// testCase1
		int[] array = { 5, 9, 7, 10 };
		int divisor = 5;
		solution12910 soultion = new solution12910();
		soultion.solution(array, divisor); // { 5, 10 }
		
		// testCase2
		array = new int[]{ 2, 36, 1, 3 };
		divisor = 1;
		soultion.solution(array, divisor); // { 1, 2, 3, 36 }
		
		// testCase3
		array = new int[]{ 3, 2, 6 };
		divisor = 10;
		soultion.solution(array, divisor); // { -1 }
	}
}