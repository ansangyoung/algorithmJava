// https://programmers.co.kr/learn/courses/30/lessons/77484
// 로또의 최고 순위와 최저 순위


package main.list;

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        HashMap<Integer, Boolean>hashMap = new HashMap<Integer, Boolean>();
        for(int win_nums_val : win_nums) {
        	hashMap.put(win_nums_val, true);
        }
        
        int minCorrectNumber = 0;
        int maxCorrectNumber = 0;
        int zeroNumber = 0;
        for(int lottosVal : lottos) {
        	if(lottosVal == 0) {
        		zeroNumber++;
        	} else if (hashMap.get(lottosVal) != null) {
        		minCorrectNumber++;
        	}
        }
        maxCorrectNumber = minCorrectNumber + zeroNumber;
        
        int minRanking = 6;
        int maxRanking = 6;
        switch(minCorrectNumber) {
        	case 6:
        		minRanking = 1;
        		break;
        	case 5:
        		minRanking = 2;
        		break;
        	case 4:
        		minRanking = 3;
        		break;
        	case 3:
        		minRanking = 4;
        		break;
        	case 2:
        		minRanking = 5;
        		break;
        }
        
        switch(maxCorrectNumber) {
	    	case 6:
	    		maxRanking = 1;
	    		break;
	    	case 5:
	    		maxRanking = 2;
	    		break;
	    	case 4:
	    		maxRanking = 3;
	    		break;
	    	case 3:
	    		maxRanking = 4;
	    		break;
	    	case 2:
	    		maxRanking = 5;
	    		break;
	    }
        
        answer = new int[] {maxRanking, minRanking};

for(int i = 0; i < 2; i++) {
System.out.println(answer[i]);
}
System.out.println("");

        return answer;
    }
}

public class list77484 {
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		Solution soultion = new Solution();
		soultion.solution(lottos, win_nums); // [3, 5]
		
		lottos = new int[] {0, 0, 0, 0, 0, 0};
		win_nums = new int[] {38, 19, 20, 40, 15, 25};
		soultion.solution(lottos, win_nums); // [1, 6]
		
		lottos = new int[] {45, 4, 35, 20, 3, 9};
		win_nums = new int[] {20, 9, 3, 45, 4, 35};
		soultion.solution(lottos, win_nums); // [1, 1]
	}
}