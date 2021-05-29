// https://programmers.co.kr/learn/courses/30/lessons/42862
// 체육복
// https://programmers.co.kr/learn/courses/30/lessons/42862/solution_groups?language=java 참조
package list;
import java.util.*;


class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n + 2];
        int answer = n;

        for (int lostVal : lost) {
            people[lostVal]--;
        }
        
        for (int reserveVal : reserve) {
            people[reserveVal]++;
        }
        
        int peopleLen = people.length;
        for (int i = 1; i < peopleLen; i++) {
            if(people[i] == -1) {
                if(people[i - 1] == 1) {
                    people[i]++;
                    people[i - 1]--;
                } else if(people[i+1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                } else {
                    answer--;
                }
            }
        }
System.out.println("answer:" + answer);
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
		
		n = 5;
		lost = new int[] {1, 3, 5};
		reserve = new int[] {2, 4};
		soultion.solution(n, lost, reserve); // 4

		n = 6;
		lost = new int[] {1, 3, 5};
		reserve = new int[] {2, 4, 6};
		soultion.solution(n, lost, reserve); // 6
	}
}
