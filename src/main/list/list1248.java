// https://leetcode.com/problems/count-number-of-nice-subarrays/
// 1248. Count Number of Nice Subarrays
// https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419378/JavaC%2B%2BPython-Sliding-Window-atMost(K)-atMost(K-1) 참고
package main.list;

public class list1248 {
	public static int numberOfSubarrays(int[] nums, int k) {
		int res = 0;
		int i = 0;
		int cnt = 0;
		int numsLen = nums.length;
		for (int j = 0; j < numsLen; j++) {
			if (nums[j] % 2 == 1) {
				k--;
				cnt = 0;
			}
			while (k == 0) {
				k += nums[i++] & 1;
				cnt++;
			}
//System.out.println("nums[" + j + "]:" + nums[j] + ", cnt:" + cnt);
			res += cnt;
		}
//System.out.println("");
//System.out.println("res:" + res);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2, 1, 1 };
		int k = 3;
		numberOfSubarrays(nums, k); // 2

		nums = new int[] { 2, 4, 6 };
		k = 1;
		numberOfSubarrays(nums, k); // 0

		nums = new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
		k = 2;
		numberOfSubarrays(nums, k); // 16
	}
}