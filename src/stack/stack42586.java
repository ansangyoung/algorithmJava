// https://programmers.co.kr/learn/courses/30/lessons/42586
// 기능개발

package stack;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> successWorkForDay = new Stack<>();
        Queue<Integer> successWorkCnt = new LinkedList<>();
        
        int speedsIdx = 0;
        int successWorkVal = 1;
        for(int progressesVal : progresses) {
        	int successNeedDay = (100 - progressesVal) / speeds[speedsIdx];
        	if((100 - progressesVal) % speeds[speedsIdx] != 0) {
        		successNeedDay++;
        	}
        	speedsIdx++;
        	if(!successWorkForDay.empty()) {
        		if(successWorkForDay.peek() >= successNeedDay) {
        			successWorkVal++;
        		} else {
        			successWorkCnt.offer(successWorkVal);
        			successWorkVal = 1;
        			successWorkForDay.pop();
        			successWorkForDay.push(successNeedDay);
        		}
        	} else {
        		successWorkForDay.push(successNeedDay);
        	}
        }
        
        if(!successWorkForDay.empty()) {
        	successWorkCnt.offer(successWorkVal);
        }
        
        int successWorkCntSize = successWorkCnt.size();
        answer = new int[successWorkCntSize];
        for(int successWorkCntIdx = 0; successWorkCntIdx < successWorkCntSize; successWorkCntIdx++) {
        	answer[successWorkCntIdx] = successWorkCnt.poll();
        }
/*
for(int chkAnswerVal : answer) {
System.out.println("chkAnswerVal:" + chkAnswerVal);
}
System.out.println();
*/
        return answer;
    }
}

public class stack42586 {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		Solution soultion = new Solution();
		soultion.solution(progresses, speeds);	// {2, 1}
		
		progresses = new int[] {95, 90, 99, 99, 80, 99};
		speeds = new int[] {1, 1, 1, 1, 1, 1};
		soultion.solution(progresses, speeds);	// {1, 3, 2}
	}
}