// https://programmers.co.kr/learn/courses/30/lessons/42862
// 체육복
package list;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int nMin = 1;
        int nMax = n;
        int extraNum = 30;
        int[] studentTmp = new int[nMax + 1];
        
        for(int i = 1; i <= nMax; i++) {
        	studentTmp[i] = 1;
        }
        
        for(int lostVal : lost) {
        	studentTmp[lostVal]--;
        }
        
        for(int reserveVal : reserve) {
        	if(studentTmp[reserveVal] == 0) {
        		studentTmp[reserveVal] = 1;
        	} else {
        		studentTmp[reserveVal] = extraNum;
        	}
        }
        
        for(int lostVal : lost) {
        	if(studentTmp[lostVal] == 0) {
	        	if(lostVal != nMax && studentTmp[lostVal + 1] > 2) {
	        		studentTmp[lostVal]++;
	        		studentTmp[lostVal + 1]--;
	        	}
	        	
	        	if(lostVal != nMin && studentTmp[lostVal - 1] > 2) {
	        		studentTmp[lostVal]++;
	        		studentTmp[lostVal - 1]--;
	        	}
        	}
        }
        
        for(int i = 1; i <= nMax; i++) {
//System.out.println(i + ":" + studentTmp[i]);
        	if(studentTmp[i] == extraNum - 2) {
        		if(studentTmp[i - 1] == 1 && studentTmp[i + 1] == 1) {
        			answer -= 1;
        		}
        	}
        	
        	if(studentTmp[i] > 0) {
        		if(studentTmp[i] > 2) {
        			answer += 1;
        		} else {
        			if(studentTmp[i] == 2) {
        				answer -= 1;
        			}
        			answer += studentTmp[i];
        		}
        	}
        }
//System.out.println("answer:" + answer);
//System.out.println("");
        return answer;
    }
}

public class list42862 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		
		Solution soultion = new Solution();
		soultion.solution(n, lost, reserve); // 5
		
		n = 5;
		lost = new int[] {2, 4};
		reserve = new int[] {3 };
		soultion.solution(n, lost, reserve); // 4
		
		n = 3;
		lost = new int[] {3 };
		reserve = new int[] {1 };
		soultion.solution(n, lost, reserve); // 2
		
		n = 5;
		lost = new int[] {2, 4};
		reserve = new int[] {1, 5};
		soultion.solution(n, lost, reserve); // 5
		
		n = 5;
		lost = new int[] {3 };
		reserve = new int[] {2, 4};
		soultion.solution(n, lost, reserve); // 5
		
		n = 5;
		lost = new int[] {2, 4 };
		reserve = new int[] {3, 5};
		soultion.solution(n, lost, reserve); // 5
	}
}