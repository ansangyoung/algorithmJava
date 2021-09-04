// https://programmers.co.kr/learn/courses/30/lessons/12977
// 소수 만들기
package main.list;
import java.util.*;

class Solution3 {
    public int solution(int[] nums) {
        int answer = 0;
        int sosuChkMax = 1000 + 999 + 998 + 1;
        int[] eratosthenesOfCyrene = new int[sosuChkMax];
        for(int i = 2; i < sosuChkMax; i++) {
        	eratosthenesOfCyrene[i] = i;
        }
        
        for(int i = 2; i < sosuChkMax; i++) {
        	for(int j = i + i; j < sosuChkMax; j++) {
        		if (eratosthenesOfCyrene[j] % i == 0 && eratosthenesOfCyrene[j] != 0) {
        			eratosthenesOfCyrene[j] = 0;
        		}
        	}
        }
        
        int numsLen = nums.length;
        for(int i = 0; i < numsLen; i++) {
        	for(int j = i + 1; j < numsLen; j++) {
        		for(int k = j + 1; k < numsLen; k++) {
        			int sosuChk = nums[i] + nums[j] + nums[k];
        			if(eratosthenesOfCyrene[sosuChk] != 0) {
        				answer++;
        			}
        		}
        	}
        }
System.out.println("answer:" + answer);
        return answer;
    }
}

public class list12977 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		
		Solution3 soultion = new Solution3();
		soultion.solution(nums); // 1
		
		nums = new int[] {1, 2, 7, 6, 4};
		soultion.solution(nums); // 4
	}
}