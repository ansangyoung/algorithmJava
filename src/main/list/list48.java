// https://leetcode.com/problems/rotate-image/
// 48. Rotate Image
package main.list;

public class list48 {
	public static void rotate(int[][] matrix) {
		int iLen = matrix.length;
		int jLen = matrix[0].length;
		int iLenCopy = matrix.length;
		int jLenCopy = matrix[0].length;

		int i = 0;
		int j = 0;
		while (i < iLenCopy / 2 + 1) {
			int k = 0;
			while (k < jLenCopy - 1 - 2 * j) {
				int matrixTmp = matrix[i][j + k];
				matrix[i][j + k] = matrix[i + k][jLen - 1];
				matrix[i + k][jLen - 1] = matrixTmp;

				matrixTmp = matrix[i][j + k];
				matrix[i][j + k] = matrix[iLen - 1][jLen - 1 - k];
				matrix[iLen - 1][jLen - 1 - k] = matrixTmp;

				matrixTmp = matrix[i][j + k];
				matrix[i][j + k] = matrix[iLen - 1 - k][j];
				matrix[iLen - 1 - k][j] = matrixTmp;

				k++;
			}
			i++;
			j++;
			iLen--;
			jLen--;
		}
/*
		for (i = 0; i < iLenCopy; i++) {
			for (j = 0; j < jLenCopy; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
*/
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix); // [[7,4,1],[8,5,2],[9,6,3]]

		matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		rotate(matrix); // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

		matrix = new int[][] { { 1 } };
		rotate(matrix); // [[1]]

		matrix = new int[][] { { 1, 2 }, { 3, 4 } };
		rotate(matrix); // [[3,1],[4,2]]
	}
}