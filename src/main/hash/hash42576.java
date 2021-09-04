// https://programmers.co.kr/learn/courses/30/lessons/42576
// 완주하지 못한 선수
// https://siyoon210.tistory.com/85 참고
// https://github.com/siyoon210/Algorithm-DataStructure/blob/master/src/exercise/hash/Hash.java 참고
package main.hash;

import java.util.LinkedList;

class Node {
	String key;
	int value;

	public Node(String key, int value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

class HashTable {
	LinkedList<Node>[] datas;
	
	public HashTable(int size) {
		datas = new LinkedList[size];
	}
	
	int getHashCode(String key) {
		int hashCode = 0;
		for (char c : key.toCharArray()) {
			hashCode += c;
		}
		return hashCode;
	}
	
	int convertHashCodeToIndex(int hashCode) {
		int hashCodeToIndex = hashCode % datas.length;	
		return hashCodeToIndex;
	}
	
	Node searchNode(LinkedList<Node> list, String key) {
		if (list == null) {
			return null;
		}
		
		for (Node node : list) {
			if (key.equals(node.getKey())) {
				return node;
			}
		}
		return null;
	}
	
	void put(String key, int value) {
		int hashCode = getHashCode(key);
		int index = convertHashCodeToIndex(hashCode);
		LinkedList<Node> list = datas[index];
		
		if (list == null) {
			list = new LinkedList<>();
			datas[index] = list;
		}
		
		Node node = searchNode(list, key);
		
		if (node == null) {
			list.add(new Node(key, value));
		} else {
			// 동명이인의 경우 생각하여 1명 이상 가능
			int valueChg = node.getValue() + 1;
			node.setValue(valueChg);
		}
	}
	
	void chgValueByKey(String key) {
		int hashCode = getHashCode(key);
		int index = convertHashCodeToIndex(hashCode);
		LinkedList<Node> list = datas[index];
		
		Node node = searchNode(list, key);
		
		int valueChg = node.getValue() - 1;
		node.setValue(valueChg);
	}
	
	boolean getValueByKey(String key) {
		int hashCode = getHashCode(key);
		int index = convertHashCodeToIndex(hashCode);
		LinkedList<Node> list = datas[index];
		
		Node node = searchNode(list, key);
		int value = node.getValue();
		boolean valueChk = false;
		
		// 완주못한 한 명의 선수만 존재할 것이라 기대
		if(value == 1) {
			valueChk = true;
		}
		return valueChk;
	}
}

class Solution2 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		
		// 계산결과 하나의 인덱스로 전부 들어갈 경우(최대)
		int participantLen = participant.length;
		HashTable hashTableParticipant = new HashTable(participantLen);
		int partEnter = 1;
		for(String part : participant) {
			hashTableParticipant.put(part, partEnter);
		}
		
		for(String comp : completion) {
			hashTableParticipant.chgValueByKey(comp);
		}
		
		for(String part : participant) {
			if(hashTableParticipant.getValueByKey(part)) {
				answer = part;
				break;
			}
		}
System.out.println("answer:" + answer);
		return answer;
	}
}

public class hash42576 {
	public static void main(String[] args) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		
		Solution2 soultion = new Solution2();
		soultion.solution(participant, completion);	//"leo"
		
		participant = new String[] { "marina", "josipa", "nikola", "vinko", "filipa" };
		completion = new String[] { "josipa", "filipa", "marina", "nikola" };
		soultion.solution(participant, completion);	//"vinko"
		
		participant = new String[] { "mislav", "stanko", "mislav", "ana" };
		completion = new String[] { "stanko", "ana", "mislav" };
		soultion.solution(participant, completion); //"mislav"
	}
}