// https://programmers.co.kr/learn/courses/30/lessons/12926
// 프로그래머스 > 코딩테스트 연습 > 연습문제 > 시저 암호
package main.string;

class Solution12926 {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if('a' <= value && value <= 'z') {
                if('z' < value + n) {
                    value = (char) (value + n - 1 - 'z' + 'a');
                } else {
                    value = (char) (value + n);
                }
            } else if ('A' <= value && value <= 'Z') {
                if('Z' < value + n) {
                    value = (char) (value + n - 1 - 'Z' + 'A');
                } else {
                    value = (char) (value + n);
                }
            }
            answer += String.valueOf(value);
        }
System.out.println(answer);
        return answer;
    }
}

public class string12926 {
	public static void main(String[] args) {
		// testCase1
		String s = "AB";
		int n = 1;
		Solution12926 soultion = new Solution12926();
		soultion.solution(s, n); // "BC"
		
		// testCase2
		s = "z";
		n = 1;
		soultion.solution(s, n); // "a"
		
		// testCase3
		s = "a B z";
		n = 4;
		soultion.solution(s, n); // "e F d"
	}
}