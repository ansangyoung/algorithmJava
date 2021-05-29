// https://programmers.co.kr/learn/courses/30/lessons/1845
// 폰켓몬

package set;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();
        int numsLen = nums.length;
        for(int i = 0; i < numsLen; i++) {
        	set.add(nums[i]);
        }
        
        int setSize = set.size();
        answer = setSize > numsLen/2 ? numsLen/2 : setSize;
//System.out.println("answer:" + answer);
        return answer;
    }
}

public class set1845 {
	public static void main(String[] args) {
		int[] nums = {3, 1, 2, 3};
		Solution soultion = new Solution();
		soultion.solution(nums); // 2
		
		nums = new int[] {3, 3, 3, 2, 2, 4};
		soultion.solution(nums); // 3
		
		nums = new int[] {3, 3, 3, 2, 2, 2};
		soultion.solution(nums); // 2
	}
}
