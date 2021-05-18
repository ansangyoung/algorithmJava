// https://programmers.co.kr/learn/courses/30/lessons/42840
// 모의고사
package list;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] mathGiveUpMan1 = {1, 2, 3, 4, 5};
        int[] mathGiveUpMan2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] mathGiveUpMan3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[][] solveCnt = {{1, 0}, {2, 0}, {3, 0}};
        
        int answersLen = answers.length;
        for(int i = 0; i < answersLen; i++) {
        	if(mathGiveUpMan1[i%5] == answers[i]) {
        		solveCnt[0][1]++;
        	}
        	
        	if(mathGiveUpMan2[i%8] == answers[i]) {
        		solveCnt[1][1]++;
        	}
        	
        	if(mathGiveUpMan3[i%10] == answers[i]) {
        		solveCnt[2][1]++;
        	}
        }
        
        Arrays.sort(solveCnt, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[1] == o2[1]) {
        			return o1[1] - o2[1];
        		} else {
        			return o2[1] - o1[1];
        		}
        	}
        });
        
        int solveCntLen = solveCnt.length;
        int answerLen = 1;
        for(int i = 0; i < solveCntLen - 1; i++) {
			if(solveCnt[i][1] == solveCnt[i + 1][1]) {
        		answerLen++;
        	} else {
        		break;
        	}
        }
        
        answer = new int[answerLen];
        for(int i = 0; i < answerLen; i++) {
        	answer[i] = solveCnt[i][0];
        }
/*
System.out.println("answerLen:" + answerLen);
for(int i = 0; i < answerLen; i++) {
System.out.println(solveCnt[i][0] + " " + solveCnt[i][1]);
}
System.out.println("");
*/
        return answer;
    }
}

public class list42840 {
	public static void main(String[] args) {
		int[] answer = {1, 2, 3, 4, 5};
		
		Solution soultion = new Solution();
		soultion.solution(answer);			// [1]
		
		answer = new int[] {1, 3, 2, 4, 2};
		soultion.solution(answer);			// [1,2,3]
	}
}