// https://leetcode.com/problems/permutations/
// 46. Permutations
// https://iamheesoo.github.io/blog/algo-leet46 참고
package main.list;

import java.util.*;
class Solution6 {
	int n;
	boolean[] visit;
	List<List<Integer>> result;
	
	public List<List<Integer>> permute(int[] nums) {
		n = nums.length;
		visit = new boolean[n];
		result = new ArrayList<List<Integer>>();
		
		permutation(new ArrayList<Integer>(), nums);
System.out.println("result:" + result);
		return result;
	}
	
	public void permutation(ArrayList<Integer> list, int[] nums) {
		if (list.size() == n) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (visit[i]) {
				continue;
			}
			visit[i] = true;
			list.add(nums[i]);
			permutation(list, nums);
			
			list.remove(list.size() - 1);
			visit[i] = false;
		}
	}
}

public class list46 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		
		Solution6 soultion = new Solution6();
		List<List<Integer>> result;
		result = soultion.permute(nums); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	}
}