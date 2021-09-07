// https://www.acmicpc.net/source/15810721 참고
// https://www.acmicpc.net/problem/1260
// DFS와 BFS
package main.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//public class Main {
public class dfsBfs1260 {

	static void bfs(int V, StringBuilder sb) {
		int a = V;
		que.add(a);
		visit[a] = true;
		while (!que.isEmpty()) {
			int curr = que.poll();
			sb.append(curr).append(" ");
			for (int j = 0; j < list[curr].size(); j++) {
				int next = list[curr].get(j);
				if (visit[next] == false) {
					visit[next] = true;
					que.add(next);
				}
			}
		}
	}

	static void dfs(int V, StringBuilder sb) {
		int a = V;
		visit[a] = true;
		sb.append(a).append(" ");
		for (int i = 0; i < list[a].size(); i++) {
			int next = list[a].get(i);
			if (visit[next] == false) {
				dfs(next, sb);
			}
		}
	}

	static int N, M, V, s, e;
	static ArrayList<Integer>[] list;
	static boolean visit[];
	static StringBuilder sb;
	static Queue<Integer> que;

	public static void main(String args[]) throws IOException {
		// System.setIn(new FileInputStream("src/dfsbfs_1260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		que = new LinkedList<>();		
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}

		sb = new StringBuilder();
		visit = new boolean[N + 1];
		dfs(V, sb);
		System.out.println(sb.toString());

		sb = new StringBuilder();
		visit = new boolean[N + 1];
		bfs(V, sb);
		System.out.println(sb.toString());
	}
}