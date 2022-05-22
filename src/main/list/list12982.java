// https://programmers.co.kr/learn/courses/30/lessons/12982
// 코딩테스트 연습 > Summer/Winter Coding(~2018) > 예산
package main.list;

import java.util.ArrayList;
import java.util.Collections;

class solution12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        // Collections.sort를 사용하기 위한 ArrayList 사용
        ArrayList<Integer> arrayToArrayList = new ArrayList<Integer>();
        int dLen = d.length;
        for(int i = 0; i < dLen; i++) {
        	arrayToArrayList.add(d[i]);
        }
        
        // 오름차순 정렬
        Collections.sort(arrayToArrayList);
        
        // 신청한 금액이 낮은 부서부터 금액을 누적하면서, 예산에 초과하는지 검사한다.
        for(int i = 0; i < dLen; i++) {
        	int deptApplyAmt = arrayToArrayList.get(i);
        	if(budget - deptApplyAmt >= 0) {
        		answer++;
        		budget -= deptApplyAmt;
        	} else {
        		break;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}

public class list12982 {
	public static void main(String[] args) {
		// testCase1
		int[] d = new int[] {1, 3, 2, 5, 4};
		int budget = 9;

		solution12982 soultion = new solution12982();
		soultion.solution(d, budget); // 3
		
		
		// testCase2
		d = new int[] {2, 2, 3, 3};
		budget = 10;
		soultion.solution(d, budget); // 4
	}
}