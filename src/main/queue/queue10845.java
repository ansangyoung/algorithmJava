// https://www.acmicpc.net/source/28072579 참고
package main.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//public class Main {
public class queue10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<String> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			String command = br.readLine();
			switch (command) {
				case "pop":
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.pollFirst()).append("\n");
					}
					break;
					
				case "size":
					sb.append(deque.size()).append("\n");
					break;
					
				case "empty":
					if (deque.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
					
				case "front":
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.peekFirst()).append("\n");
					}
					break;
					
				case "back":
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.peekLast()).append("\n");
					}
					break;
					
				// push x
				default :
					deque.offer(command.substring(5));
					break;
			}
		}
		System.out.println(sb);
	}
}
