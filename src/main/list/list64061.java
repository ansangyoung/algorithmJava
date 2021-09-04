// https://programmers.co.kr/learn/courses/30/lessons/64061
// 크레인 인형뽑기 게임

package main.list;

import java.util.*;
class Solution7 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		HashMap<Integer, Integer> boardHeightMaxIdx = new HashMap<Integer, Integer>();
		int boardLen = board.length;
		for(int i = 0; i < boardLen; i++) {
			for(int j = 0; j < boardLen; j++) {
				if(boardHeightMaxIdx.get(j + 1) == null && board[i][j] != 0) {
					boardHeightMaxIdx.put(j + 1, boardLen - i);
				}
			}
		}
		
		// null 체크
		for(int i = 0; i < boardLen; i++) {
			if(boardHeightMaxIdx.get(i + 1) == null) {
				boardHeightMaxIdx.put(i + 1, 0);
			}
		}
		
		Stack<Integer> stack = new Stack();
		
		for(int movesIdx : moves) {
			int selBoardHeightIdx = boardHeightMaxIdx.get(movesIdx);
			if(selBoardHeightIdx > 0) {
				int movesVal = board[boardLen - selBoardHeightIdx][movesIdx - 1];
				if(movesVal != 0) {
					boardHeightMaxIdx.put(movesIdx, selBoardHeightIdx - 1);
					
					if(!stack.empty() && stack.peek() == movesVal) {
						answer += 2;
						stack.pop();
					} else {
						stack.push(movesVal);
					}
				}
			}
		}
System.out.println("answer:" + answer);
		return answer;
	}
}

public class list64061 {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		Solution7 soultion = new Solution7();
		soultion.solution(board, moves); // 4
	}
}