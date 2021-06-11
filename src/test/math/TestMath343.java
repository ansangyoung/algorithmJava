// https://leetcode.com/problems/integer-break/
// 343. Integer Break
package test.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestMath343 {
	private final main.math.math343 math343 = new main.math.math343();

	@Test
	void TestSoluton() {
		int n = 2;
		int expectInt = 1;
		int resRetInt = math343.integerBreak(n);
		assertEquals(expectInt, resRetInt);

		n = 10;
		expectInt = 36;
		resRetInt = math343.integerBreak(n);
		assertEquals(expectInt, resRetInt);

		n = 5;
		expectInt = 6;
		resRetInt = math343.integerBreak(n);
		assertEquals(expectInt, resRetInt);

		// assertEquals(expectInt, 987);
	}
}