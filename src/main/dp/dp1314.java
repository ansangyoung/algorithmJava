// https://leetcode.com/problems/matrix-block-sum/
// 1314. Matrix Block Sum
package main.dp;

public class dp1314 {
	public static int[][] matrixBlockSum(int[][] mat, int k) {
		int iLen = mat.length + 1;
		int jLen = mat[0].length + 1;
		int[][] dpSum = new int[iLen][jLen];
		int[][] res = new int[iLen][jLen];
		for (int i = 1; i < iLen; i++) {
			for (int j = 1; j < jLen; j++) {
				dpSum[i][j] = mat[i - 1][j - 1] + dpSum[i - 1][j] + dpSum[i][j - 1] - dpSum[i - 1][j - 1];
			}
		}

		for (int i = 1; i < iLen; i++) {
			for (int j = 1; j < jLen; j++) {
				int iIdxCal = i + k < iLen ? i + k : iLen - 1;
				int jIdxCal = j + k < jLen ? j + k : jLen - 1;
				res[i][j] = dpSum[iIdxCal][jIdxCal];

				if (i - k - 1 > 0) {
					res[i][j] -= dpSum[i - k - 1][jIdxCal];
				}
				if (j - k - 1 > 0) {
					res[i][j] -= dpSum[iIdxCal][j - k - 1];
				}
				if (i - k - 1 > 0 && j - k - 1 > 0) {
					res[i][j] += dpSum[i - k - 1][j - k - 1];
				}
			}
		}
/*
		for (int i = 1; i < iLen; i++) {
			for (int j = 1; j < jLen; j++) {
				System.out.print("res[" + i + "][" + j + "] = " + res[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
*/
		int[][] chgRes = new int[iLen - 1][jLen - 1];
		for (int i = 1; i < iLen; i++) {
			for (int j = 1; j < jLen; j++) {
				chgRes[i - 1][j - 1] = res[i][j];
			}
		}
		return chgRes;
	}

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int k = 1;
		matrixBlockSum(mat, k); // [[12,21,16],[27,45,33],[24,39,28]]

		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		k = 2;
		matrixBlockSum(mat, k); // [[45,45,45],[45,45,45],[45,45,45]]

		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		k = 3;
		matrixBlockSum(mat, k); // [[45,45,45],[45,45,45],[45,45,45]]

		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		k = 4;
		matrixBlockSum(mat, k); // [[45,45,45],[45,45,45],[45,45,45]]
		
		mat = new int[][] {{67,64,78},{99,98,38},{82,46,46},{6,52,55},{55,99,45}};
		k = 3;
		matrixBlockSum(mat, k);
	}
}