// https://www.acmicpc.net/problem/1003
// 피보나치 함수
package main.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//public class Main {
public class basic1003 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] inputValue = new int[t];
		for(int i = 0; i < t; i++) {
			inputValue[i] = Integer.parseInt(br.readLine());
		}
		long[] outputValueZeroCnt = new long[41];
		long[] outputValueOneCnt = new long[41];
		outputValueZeroCnt[0] = 1;
		outputValueOneCnt[0] = 0;
		
		outputValueZeroCnt[1] = 0;
		outputValueOneCnt[1] = 1;
		
		for(int i = 2; i <= 40; i++) {
			outputValueZeroCnt[i] = outputValueZeroCnt[i-1] + outputValueZeroCnt[i-2];
			outputValueOneCnt[i] = outputValueOneCnt[i-1] + outputValueOneCnt[i-2];
		}
		
		for(int i = 0; i < t; i++) {
			System.out.println(outputValueZeroCnt[inputValue[i]] + " " + outputValueOneCnt[inputValue[i]]);
		}
	}	
}