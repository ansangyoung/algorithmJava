// https://leetcode.com/problems/my-calendar-ii/
// 731. My Calendar II
// https://leetcode.com/problems/my-calendar-ii/solution/ 참고
package main.list;

import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
	List<int[]> calendar;
	List<int[]> overlaps;

	MyCalendarTwo() {
		calendar = new ArrayList();
		overlaps = new ArrayList();
	}

	public boolean book(int start, int end) {
		for (int[] iv : overlaps) {
			if (iv[0] < end && start < iv[1]) {
				return false;
			}
		}

		for (int[] iv : calendar) {
			if (iv[0] < end && start < iv[1]) {
				overlaps.add(new int[] { Math.max(start, iv[0]), Math.min(end, iv[1]) });
			}
		}

		calendar.add(new int[] { start, end });
		return true;
	}
}

public class list731 {
	public static void main(String[] args) {
		int[][] book = new int[][] { {}, { 10, 20 }, { 50, 60 }, { 10, 40 }, { 5, 15 }, { 5, 10 }, { 25, 55 } };
		MyCalendarTwo obj = new MyCalendarTwo();
		for (int[] iv : book) {
			if (iv.length == 0) {
				System.out.println("null");
				continue;
			}
			int start = iv[0];
			int end = iv[1];
			boolean param_1 = obj.book(start, end);
			System.out.println(param_1);
		}
	}
}