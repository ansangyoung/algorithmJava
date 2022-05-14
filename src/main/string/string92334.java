// https://programmers.co.kr/learn/courses/30/lessons/92334
package main.string;

import java.util.ArrayList;
import java.util.HashMap;

class Solution92334 {
	public int[] solution(String[] id_list, String[] report, int k) {
		// 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return
		int[] answer = new int[id_list.length];
		
		// 키: 신고한 사람, 값: 처리 결과에 대한 받을 메일 수
		HashMap<String, Integer> toReportMailCnt = new HashMap<String, Integer>();
		
		// 키: 신고 받은 사람, 값: 신고한 사람들
		HashMap<String, ArrayList<String>> receiveReport = new HashMap<String, ArrayList<String>>();
		
		// 초기값 세팅
		for(int i = 0; i < id_list.length; i++) {
			toReportMailCnt.put(id_list[i], 0);
			receiveReport.put(id_list[i], new ArrayList<String>());
		}
		
		// 신고 받은 사람을 기준으로, 신고한 사람을 리스트에 추가
		for(String reportVal : report) {
			String[] reportValSplit = reportVal.split(" ");
			String toReportVal = reportValSplit[0];
			String receiveReportVal = reportValSplit[1];
			
			ArrayList<String> beforeToReport = receiveReport.get(receiveReportVal);
			boolean chkBeforeLog = true;
			for(String toReport : beforeToReport) {
				if(toReport.equals(toReportVal)) {
					chkBeforeLog = false;
					break;
				}
			}
			
			if(chkBeforeLog) {
				beforeToReport.add(toReportVal);
				receiveReport.put(receiveReportVal, beforeToReport);
			}
		}
		
		// 신고한 사람이 받을 메일 수 저장
		for(int i = 0; i < id_list.length; i++) {
			ArrayList<String> totalToReport = receiveReport.get(id_list[i]);
			if(totalToReport.size() >= k) {
				for(int j = 0; j < totalToReport.size(); j++) {
					toReportMailCnt.put(totalToReport.get(j), toReportMailCnt.get(totalToReport.get(j)) + 1);
				}
			}
		}
		
		for(int i = 0; i < id_list.length; i++) {
			answer[i] = toReportMailCnt.get(id_list[i]);
		}
		
		// 결과값 확인
		for(int i = 0; i < id_list.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println("");
		
		
		return answer;
	}
}

public class string92334 {
	public static void main(String[] args) {
		// testCase1
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		
		Solution92334 soultion = new Solution92334();
		soultion.solution(id_list, report, k); // {2, 1, 1, 0}
		
		
		// testCase2
		id_list = new String[]{"con", "ryan"};
		report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
		
		k = 3;
		soultion.solution(id_list, report, k); // {0, 0}
	}
}