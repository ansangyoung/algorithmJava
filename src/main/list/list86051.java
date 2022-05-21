// https://programmers.co.kr/learn/courses/30/lessons/86051
// 코딩테스트 연습 > 월간 코드 챌린지 시즌3 > 없는 숫자 더하기
package main.list;

class solution86051 {
    public int solution(int[] numbers) {
        int answer = 45;
        
        for(int i : numbers) {
        	answer -= i;
        }
System.out.println(answer);
        return answer;
    }
}

public class list86051 {
	public static void main(String[] args) {
		// testCase1
		int[] numbers = { 1,2,3,4,6,7,8,0 };

		solution86051 soultion = new solution86051();
		soultion.solution(numbers); // 14

		// testCase2
		numbers = new int[] { 5,8,4,0,6,7,9 };
		soultion.solution(numbers); // 6
	}
}