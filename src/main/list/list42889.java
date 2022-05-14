// https://programmers.co.kr/learn/courses/30/lessons/42889
package main.list;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;

class solution42889 {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		// 총 유저 수
		int userSum = stages.length;
		// 키: 스테이지, 값: 실패율
		Vector<Pair> result = new Vector<Pair>();
		// 각 층에 머무르고 있는 유저 수
		HashMap<Integer, Integer> stageChallengeUser = new HashMap<Integer, Integer>();
		// 각 층에 도전한 유저 수
		HashMap<Integer, Integer> stageChallengeUserAccumulate = new HashMap<Integer, Integer>();
		
		// 초기화
		for(int i = 1; i <= N; i++) {
			stageChallengeUser.put(i, 0);
		}
		// 각 층에 머무르고 있는 유저 수
		for(int i = 0; i < userSum; i++) {
			if(stages[i] <= N) {
				stageChallengeUser.put(stages[i], stageChallengeUser.get(stages[i]) + 1);
			}
		}
		
		// 각 층에 도전한 유저 수
		for(int i = 1; i <= N; i++) {
			stageChallengeUserAccumulate.put(i, userSum);
			for(int j = 1; j < i; j++) {
				stageChallengeUserAccumulate.put(i, stageChallengeUserAccumulate.get(i) - stageChallengeUser.get(j));
			}
		}

		// 실패율 계산
		for(int i = 1; i <= N; i++) {
			double stageFailureLate = 0;
			if(stageChallengeUserAccumulate.get(i) != 0) {
				stageFailureLate = (double)stageChallengeUser.get(i)/stageChallengeUserAccumulate.get(i);
			}
			
			result.add(new Pair(i, stageFailureLate));
		}
		
		// 정렬
		// 실패율 내림차순, 동률의 경우 작은번호 우선
        Collections.sort(result, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
            	// second 먼저 내림차순
                if(p1.second > p2.second) {
                    return -1;
                }
                // 같으면 first 오름차순
                else if(p1.second == p2.second) {
                    return Integer.compare(p1.first, p2.first);
                }
                else {
                    return 1;
                }
            }
        });
		
		// 결과값 저장
		for(int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i).first;
		}
		
		return answer;
	}
}

class Pair {
    int first;
    double second;
    
    Pair(int first, double second) {
        this.first = first;
        this.second = second;
    }
}

public class list42889 {
	public static void main(String[] args) {
		// testCase1
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

		solution42889 soultion = new solution42889();
		soultion.solution(N, stages); // {3,4,2,1,5}

		// testCase2
		N = 4;
		stages = new int[] { 4, 4, 4, 4, 4 };
		soultion.solution(N, stages); // {4,1,2,3}
	}
}