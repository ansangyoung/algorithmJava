// https://programmers.co.kr/learn/courses/30/lessons/12933
// 코딩테스트 연습 > 연습문제 > 정수 내림차순으로 배치하기
package main.list;

import java.util.ArrayList;
import java.util.Collections;

class solution12933 {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Integer> eachDigit = new ArrayList<Integer>();
        while(n > 0) {
            eachDigit.add((int)(n%10));
            n /= 10;
        }
        
        Collections.sort(eachDigit);
        Collections.reverse(eachDigit);
        
        for(int value : eachDigit) {
            answer += value;
            answer *= 10;
        }
        answer /= 10;
System.out.println(answer);
        return answer;
    }
}

public class list12933 {
	public static void main(String[] args) {
		// testCase1
		long n = 118372;

		solution12933 soultion = new solution12933();
		soultion.solution(n); // 873211
	}
}