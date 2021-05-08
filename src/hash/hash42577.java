// https://programmers.co.kr/learn/courses/30/lessons/42577
// 전화번호 목록
// 질문하기 https://programmers.co.kr/questions/17304 참고


package hash;

import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
    	HashMap<String, Integer> phoneBookHashMap = new HashMap<>();
        
        for (String phoneBookKey : phone_book) {
        	phoneBookHashMap.put(phoneBookKey, 1);
        }
        
        for (String phoneBookKey : phoneBookHashMap.keySet()) {
        	int phoneBookKeyLen = phoneBookKey.length();
            for (int chkPhoneBookKeyIdx = 1; chkPhoneBookKeyIdx <= phoneBookKeyLen; chkPhoneBookKeyIdx++) {
                String chkPhoneBookKey = phoneBookKey.substring(0, chkPhoneBookKeyIdx);
            	if (!phoneBookKey.equals(chkPhoneBookKey) && phoneBookHashMap.containsKey(chkPhoneBookKey)) {
                	answer = false;
                	break;
                }
            }
            if(!answer) {
            	break;
            }
        }
//System.out.println("answer:" + answer);
        return answer;
    }
}

public class hash42577 {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		Solution soultion = new Solution();
		soultion.solution(phone_book);	// false
		
		phone_book = new String[] {"123", "456", "789"};
		soultion.solution(phone_book);	// true
		
		phone_book = new String[] { "12", "123", "1235", "567", "88" };
		soultion.solution(phone_book); // false
	}
}