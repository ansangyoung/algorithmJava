// https://programmers.co.kr/learn/courses/30/lessons/68644
// 코딩테스트 연습 > 월간 코드 챌린지 시즌1 > 두 개 뽑아서 더하기
package main.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class solution68644 {
    public int[] solution(int[] numbers) {
		int[] answer = {};
		int numbersLen = numbers.length;
		Set<Integer> arrayToSet = new HashSet<Integer>();
        
		for(int i = 0; i < numbersLen; i++) {
	        for(int j = i + 1; j < numbersLen; j++) {
	        	arrayToSet.add(numbers[i] + numbers[j]);
	        }
		}
		
		ArrayList<Integer> setToArrayList = new ArrayList<Integer>();
		Iterator<Integer> it = arrayToSet.iterator();
		while(it.hasNext()) {
			setToArrayList.add(it.next());
		}
        
		Collections.sort(setToArrayList);

		answer = new int[setToArrayList.size()];
		int i = -1;
		for(int listValue : setToArrayList) {
			answer[++i] = listValue;
System.out.print(answer[i] + " ");
		}
System.out.println("");
		return answer;
	}
}

public class list68644 {
	public static void main(String[] args) {
		// testCase1
		int[] numbers = { 2, 1, 3, 4, 1 };
		solution68644 soultion = new solution68644();
		soultion.solution(numbers); // { 2, 3, 4, 5, 6, 7 }
		
		// testCase2
		numbers = new int[]{ 5, 0, 2, 7 };
		soultion.solution(numbers); // { 2, 5, 7, 9, 12 }	
	}
}