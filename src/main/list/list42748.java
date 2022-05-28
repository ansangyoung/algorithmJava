// https://programmers.co.kr/learn/courses/30/lessons/42748
// 코딩테스트 연습 > 정렬 > K번째수
package main.list;

import java.util.ArrayList;
import java.util.Collections;

class solution42748 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		int commandsLen = commands.length;
		answer = new int[commandsLen];
		
		for(int i = 0; i < commandsLen; i++) {
	        ArrayList<Integer> arrayToArrayList = new ArrayList<Integer>();
	        for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
	        	arrayToArrayList.add(array[j]);
	        }
	        
	        Collections.sort(arrayToArrayList);
	        answer[i] = arrayToArrayList.get(commands[i][2] - 1);
System.out.print(answer[i] + " ");
		}
		
		return answer;
	}
}

public class list42748 {
	public static void main(String[] args) {
		// testCase1
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		solution42748 soultion = new solution42748();
		soultion.solution(array, commands); // { 5, 6, 3 }
	}
}