// https://leetcode.com/problems/car-fleet/
// 853. Car Fleet
// https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419378/JavaC%2B%2BPython-Sliding-Window-atMost(K)-atMost(K-1) 참고
package main.map;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class map853 {
	public static int carFleet(int target, int[] pos, int[] speed) {
		Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < pos.length; i++) {
			map.put(pos[i], (double) (target - pos[i]) / speed[i]);
		}

		int res = 0;
		double cur = 0;
		for (double time : map.values()) {
			if (time > cur) {
				cur = time;
				res++;
			}
		}
//System.out.println("res:" + res);
		return res;
	}

	public static void main(String[] args) {
		int target = 12;
		int[] position = new int[] { 10, 8, 0, 5, 3 };
		int[] speed = new int[] { 2, 4, 1, 1, 3 };
		carFleet(target, position, speed); // 3

	}
}