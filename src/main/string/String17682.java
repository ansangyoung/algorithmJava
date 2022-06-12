// https://programmers.co.kr/learn/courses/30/lessons/17682
// 코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT > [1차] 다트 게임
package main.string;

import java.util.Stack;

class Solution17682 {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> dartEachScore = new Stack<Integer>();
        
        int currentScore = 0;
        for(int i = 0; i < dartResult.length(); i++) {
        	if('0' <= dartResult.charAt(i) && dartResult.charAt(i) <= '9') {
        		currentScore *= 10;
        		currentScore += dartResult.charAt(i) - '0';
        	} else if(dartResult.charAt(i) == 'S') {
        		currentScore *= 1;
        		dartEachScore.push(currentScore);
        		currentScore = 0;
        	} else if(dartResult.charAt(i) == 'D') {
        		currentScore *= currentScore;
        		dartEachScore.push(currentScore);
        		currentScore = 0;
        	} else if(dartResult.charAt(i) == 'T') {
        		currentScore *= currentScore * currentScore;
        		dartEachScore.push(currentScore);
        		currentScore = 0;
        	} else if(dartResult.charAt(i) == '#') {
        		currentScore = dartEachScore.pop();
        		currentScore *= -1;
        		dartEachScore.push(currentScore);
        		currentScore = 0;
        	} else if(dartResult.charAt(i) == '*') {
        		int currentScoreBefore = 0;
        		int currentScoreBeBefore = 0;
    			if(!dartEachScore.empty()) {
    				currentScoreBefore = dartEachScore.pop();
    				currentScoreBefore *= 2;
        			if(!dartEachScore.empty()) {
        				currentScoreBeBefore = dartEachScore.pop();
        				currentScoreBeBefore *= 2;
        				dartEachScore.push(currentScoreBeBefore);
            		}
        			dartEachScore.push(currentScoreBefore);
        		}
        	}
        }
        
        return answer;
    }
}

public class String17682 {
	public static void main(String[] args) {
		String dartResult = "1S2D*3T";
		Solution17682 soultion = new Solution17682();
		soultion.solution(dartResult); // 37
		
		dartResult = "1D2S#10S";
		soultion.solution(dartResult); // 9
		
		dartResult = "1D2S0T";
		soultion.solution(dartResult); // 3
		
		dartResult = "1S*2T*3S";
		soultion.solution(dartResult); // 23
		
		dartResult = "1D#2S*3S";
		soultion.solution(dartResult); // 5
		
		dartResult = "1T2D3D#";
		soultion.solution(dartResult); // -4
		
		dartResult = "1D2S3T*";
		soultion.solution(dartResult); // 59
	}
}