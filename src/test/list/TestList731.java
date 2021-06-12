// https://leetcode.com/problems/my-calendar-ii/
// 731. My Calendar II
package test.list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

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

public class TestList731 {
	private final main.list.list731 list731 = new main.list.list731();

	@Test
	void TestSoluton() {
		int[][] book = new int[][] { {}, { 10, 20 }, { 50, 60 }, { 10, 40 }, { 5, 15 }, { 5, 10 }, { 25, 55 } };
		MyCalendarTwo obj = new MyCalendarTwo();
		Object[] expectBook = new Object[] { null, true, true, true, false, true, true };
		int expectBookLen = expectBook.length;
		Object[] resRetBook = new Object[expectBookLen];

		int i = 0;
		for (int[] iv : book) {
			if (iv.length == 0) {
				resRetBook[i++] = (Boolean) null;
				continue;
			}
			int start = iv[0];
			int end = iv[1];
			boolean param_1 = obj.book(start, end);
			resRetBook[i++] = param_1;
		}

		i = 0;
		for (Object expectVal : expectBook) {
			assertEquals(expectVal, resRetBook[i++]);
		}
	}
}