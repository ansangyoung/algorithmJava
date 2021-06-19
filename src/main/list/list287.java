// https://leetcode.com/problems/find-the-duplicate-number/
// 287. Find the Duplicate Number
package main.list;

public class list287 {
    public static int findDuplicate(int[] nums) {
        int constantExtraSpace[] = new int[3126];
        int res = 0;
        for(int numsVal : nums) {
        	if(0 != (constantExtraSpace[numsVal / 32] & (1 << (numsVal % 32)))) {
        		res = numsVal;
        		break;
        	} else {
        		constantExtraSpace[numsVal / 32] += 1 << (numsVal % 32);
        	}
        }
//System.out.println("res:" + res);
        return res;
    }
    
	public static void main(String[] args) {
		int[] nums = new int[] {1, 3, 4, 2, 2};
		findDuplicate(nums);
		
		nums = new int[] {3, 1, 3, 4, 2};
		findDuplicate(nums);
		
		nums = new int[] {1, 1};
		findDuplicate(nums);
		
		nums = new int[] {1, 1, 2};
		findDuplicate(nums);
		
	}
}