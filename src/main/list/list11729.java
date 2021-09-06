// https://st-lab.tistory.com/96 참고
// 하노이 탑 이동 순서
package main.list;
import java.util.Scanner;

//public class Main {
public class list11729 {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int resultCnt = (int)Math.pow(2, n) - 1;
		sb.append(resultCnt).append('\n');
		
		Hanoi(n, 1, 2, 3);
		System.out.println(sb);
	}

	// n: 원판의 개수, start: 출발지, to: 목적지
	public static void Hanoi(int n, int start, int mid, int to) {
		if (n == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		// STEP 1 : N-1개를 A에서 B로 이동
		Hanoi(n - 1, start, to, mid);

		// STEP 2 : 1개를 A에서 C로 이동
		sb.append(start + " " + to + "\n");

		// STEP 3 : N-1개를 B에서 C로 이동
		Hanoi(n - 1, mid, start, to);
	}
}