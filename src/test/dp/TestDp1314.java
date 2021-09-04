// https://leetcode.com/problems/matrix-block-sum/
// 1314. Matrix Block Sum
package test.dp;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestDp1314 {
	private final main.dp.dp1314 dp1314 = new main.dp.dp1314();

	@Test
	@DisplayName("TestDp1314 TestSoluton()")
	void TestSoluton() {
		int[][] mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int k = 1;
		int[][] expectMat = new int[][] { { 12, 21, 16 }, { 27, 45, 33 }, { 24, 39, 28 } };
		int[][] resRetMat = dp1314.matrixBlockSum(mat, k);
		assertArrayEquals(expectMat, resRetMat);

		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		k = 2;
		expectMat = new int[][] { { 45, 45, 45 }, { 45, 45, 45 }, { 45, 45, 45 } };
		resRetMat = dp1314.matrixBlockSum(mat, k);
		assertArrayEquals(expectMat, resRetMat);

		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		k = 3;
		expectMat = new int[][] { { 45, 45, 45 }, { 45, 45, 45 }, { 45, 45, 45 } };
		resRetMat = dp1314.matrixBlockSum(mat, k);
		assertArrayEquals(expectMat, resRetMat);
		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		k = 4;
		expectMat = new int[][] { { 45, 45, 45 }, { 45, 45, 45 }, { 45, 45, 45 } };
		resRetMat = dp1314.matrixBlockSum(mat, k);
		assertArrayEquals(expectMat, resRetMat);
		// assertEquals(expectInt, 987);
	}
}