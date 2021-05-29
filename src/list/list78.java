// https://leetcode.com/problems/subsets/
// 78. Subsets
package list;

import java.util.*;

class Solution {
	int n;
	boolean[] visit;
	List<List<Integer>> result;
	HashMap<ArrayList<Integer>, Boolean> dupChk;
	
	public List<List<Integer>> subsets(int[] nums) {
		n = nums.length;
		visit = new boolean[n];
		result = new ArrayList<List<Integer>>();
		dupChk = new HashMap<ArrayList<Integer>, Boolean>();
		
		permutation(new ArrayList<Integer>(), nums);
//System.out.println("result:" + result);
		return result;
	}
	
	public void permutation(ArrayList<Integer> list, int[] nums) {
		ArrayList<Integer> listSort = new ArrayList<Integer>(list);
        Collections.sort(listSort);
        
		if(dupChk.get(listSort) == null) {
			result.add(new ArrayList<Integer>(listSort));
		} else {
			return;
		}
		dupChk.put(new ArrayList<Integer>(listSort), true);
		
		if (list.size() == n) {
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

public class list78 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		
		Solution soultion = new Solution();
		List<List<Integer>> result;
		result = soultion.subsets(nums); // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
		
		nums = new int[]{ 0 };
		result = soultion.subsets(nums); // [[],[0]]
	}
}