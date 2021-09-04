// https://st-lab.tistory.com/96 참고
package main.list;
import java.util.Scanner;

public class list11729 {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');
		
		Hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}

	/*
	 * N: 원판의 개수 
	 * start: 출발지
	 * to: 목적지
	 */
	
	public static void Hanoi(int N, int start, int mid, int to) {
		if (N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		// STEP 1 : N-1개를 A에서 B로 이동
		Hanoi(N - 1, start, to, mid);

		// STEP 2 : 1개를 A에서 C로 이동
		sb.append(start + " " + to + "\n");

		// STEP 3 : N-1개를 B에서 C로 이동
		Hanoi(N - 1, mid, start, to);
	}
}