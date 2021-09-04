// https://programmers.co.kr/learn/courses/30/lessons/67256
// 키패드 누르기

package main.list;

import java.util.*;
import java.math.*;

class Solution8 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int leftCurrentWhere = -1;
        int rightCurrentWhere = -1;
        int[][] distanceCalculateMatrix = { {0, 0}, {0, 1}, {0, 2}, 	// 1 2 3
        									{1, 0}, {1, 1}, {1, 2}, 	// 4 5 6
        									{2, 0}, {2, 1}, {2, 2}, 	// 7 8 9
        									{3, 0},	{3, 1}, {3, 2}  	// * 0 #
        								  };
        
        for(int numbersVal : numbers) {
        	String handChk = "";
        	if(numbersVal == 1 || numbersVal == 4 || numbersVal == 7) {
        		handChk = "L";
        	} else if(numbersVal == 3 || numbersVal == 6 || numbersVal == 9) {
        		handChk = "R";
        	} else {
        		int changeNumbersValForDistanceX = numbersVal > 0 ? distanceCalculateMatrix[numbersVal - 1][0] : distanceCalculateMatrix[10][0];
        		int changeNumbersValForDistanceY = numbersVal > 0 ? distanceCalculateMatrix[numbersVal - 1][1] : distanceCalculateMatrix[10][1];
        		
        		int leftDistanceCalculate = 0;
        		int rightDistanceCalculate = 0;
        		
        		if(leftCurrentWhere == -1) {
        			leftDistanceCalculate = Math.abs(changeNumbersValForDistanceX - distanceCalculateMatrix[9][0]) + Math.abs(changeNumbersValForDistanceY - distanceCalculateMatrix[9][1]);
        		} else if(leftCurrentWhere == 0) {
        			leftDistanceCalculate = Math.abs(changeNumbersValForDistanceX - distanceCalculateMatrix[10][0]) + Math.abs(changeNumbersValForDistanceY - distanceCalculateMatrix[10][1]);
        		} else {
        			leftDistanceCalculate = Math.abs(changeNumbersValForDistanceX - distanceCalculateMatrix[leftCurrentWhere - 1][0]) + Math.abs(changeNumbersValForDistanceY - distanceCalculateMatrix[leftCurrentWhere - 1][1]);
        		}
        		
        		if(rightCurrentWhere == -1) {
        			rightDistanceCalculate =  Math.abs(changeNumbersValForDistanceX - distanceCalculateMatrix[11][0]) + Math.abs(changeNumbersValForDistanceY - distanceCalculateMatrix[11][1]);
        		} else if(rightCurrentWhere == 0) {
        			rightDistanceCalculate = Math.abs(changeNumbersValForDistanceX - distanceCalculateMatrix[10][0]) + Math.abs(changeNumbersValForDistanceY - distanceCalculateMatrix[10][1]);	
        		} else {
        			rightDistanceCalculate = Math.abs(changeNumbersValForDistanceX - distanceCalculateMatrix[rightCurrentWhere - 1][0]) + Math.abs(changeNumbersValForDistanceY - distanceCalculateMatrix[rightCurrentWhere - 1][1]);
        		}
        		
        		
        		if(leftDistanceCalculate < rightDistanceCalculate) {
        			handChk = "L";
        		} else if(leftDistanceCalculate == rightDistanceCalculate){
        			if("left".equals(hand)) {
        				handChk = "L";
        			} else {
        				handChk = "R";
        			}
        		} else {
        			handChk = "R";
        		}
        	}
        	
        	if(handChk == "L") {
        		leftCurrentWhere = numbersVal;
        	} else {
        		rightCurrentWhere = numbersVal;
        	}
        	
        	answer += handChk;
        }
System.out.println("answer:" + answer);
        return answer;
    }
}

public class list67256 {
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		Solution8 soultion = new Solution8();
		soultion.solution(numbers, hand); // "LRLLLRLLRRL"
		
		numbers = new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		hand = "left";
		soultion.solution(numbers, hand); // "LRLLRRLLLRR"
		
		numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		hand = "right";
		soultion.solution(numbers, hand); // "LLRLLRLLRL"
	}
}