//https://www.acmicpc.net/problem/3052
//나머지
package main.set;

import java.util.HashSet;
import java.util.Scanner;

//public class Main {
public class set3052 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < 10; i++) {
			set.add(sc.nextInt() % 42);
		}
		System.out.println(set.size());
	}
}