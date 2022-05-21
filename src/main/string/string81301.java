// https://programmers.co.kr/learn/courses/30/lessons/81301
package main.string;

class Solution81301 {
    public int solution(String s) {
        int answer = 0;
        String afterReplaceStr = "";
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        s = s.replaceAll("zero", "0");
        
        answer = Integer.parseInt(s);
System.out.println(answer);
        return answer;
    }
}

public class string81301 {
	public static void main(String[] args) {
		// testCase1
		String s = "one4seveneight";
		Solution81301 soultion = new Solution81301();
		soultion.solution(s); // 1478
		
		s = "23four5six7";
		soultion.solution(s); // 234567
		
		s = "2three45sixseven";
		soultion.solution(s); // 234567
		
		s = "123";
		soultion.solution(s); // 123
	}
}