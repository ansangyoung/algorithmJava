// https://leetcode.com/problems/product-of-array-except-self/
// 238. Product of Array Except Self
// https://m.blog.naver.com/withham1/221320996067 참고
// https://gist.github.com/fpdjsns/566ede72670ba67c9e37a9ed5ef3d22d 참고
package main.list;
import java.util.*;

class Solution4 {
	public int[] productExceptSelf(int[] nums) {
		int numsLen = nums.length;
		int[] answer = new int[numsLen];
		Arrays.fill(answer, 1);
		
		for(int i = 1; i < numsLen; i++) {
			answer[i] = answer[i - 1] * nums[i - 1]; // [1, a, a*b, a*b*c]
		}
		
		for(int i = numsLen - 2; i >= 0; i--) {
			nums[i] = nums[i + 1] * nums[i];         // [a*b*c*d, b*c*d, c*d, d]
		}
		
		for(int i = 0; i < numsLen - 1; i++) {
			answer[i] = answer[i] * nums[i + 1];
		}
		
		for(int i = 0; i < numsLen; i++) {
System.out.print(answer[i] + " ");
		}
System.out.println("");
		return answer;
	}
}

public class list238 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		
		Solution4 soultion = new Solution4();
		soultion.productExceptSelf(nums);	// [24, 12, 8, 6]
		
		nums = new int[] {-1, 1, 0, -3, 3};
		soultion.productExceptSelf(nums);	// [0, 0, 9, 0, 0]
	}
}