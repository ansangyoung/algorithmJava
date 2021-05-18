// https://programmers.co.kr/learn/courses/30/lessons/42587
// 프린터

package stack;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int prioritiesLen = priorities.length;
        int maxPriIdx = 0;
        int maxPriVal = 0;
        int chkIdx = 0;
        
        while(true) {
        	maxPriVal = -1;
        	int tmpPrioritiesLen = prioritiesLen;
        	while(tmpPrioritiesLen-- > 0) {
        		if(chkIdx == prioritiesLen) {
        			chkIdx = 0;
        		}
        		
        		if(maxPriVal < priorities[chkIdx]) {
        			maxPriVal = priorities[chkIdx];
        			maxPriIdx = chkIdx;
        		}
        		chkIdx++;
        	}
        	
        	priorities[maxPriIdx] = -1;
        	answer++;
        	if(maxPriIdx == location) {
        		break;
        	}
        	chkIdx = maxPriIdx + 1;
        }
        
//System.out.println("answer:" + answer);
        return answer;
    }
}

public class stack42587 {
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		Solution soultion = new Solution();
		soultion.solution(priorities, location); // 1
		
		priorities = new int[] {1, 1, 9, 1, 1, 1};
		location = 0;
		soultion.solution(priorities, location); // 5
	}
}