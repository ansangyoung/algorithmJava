// https://programmers.co.kr/learn/courses/30/lessons/72410
// 신규 아이디 추천
package main.string;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class string72410 {
	
    public static String solution(String new_id) {
        String answer = "";
        int newIdLen = new_id.length();
        // 1 step
        for(char chkLargeChar = 'A'; chkLargeChar <= 'Z'; chkLargeChar++) {
        	String charToStrLarge = String.valueOf(chkLargeChar);
        	String charToStrSmall = String.valueOf((char)(chkLargeChar + 32));
        	new_id = new_id.replaceAll(charToStrLarge, charToStrSmall); 
        }
        
        
        // 2 step
        StringBuilder sb = new StringBuilder();
        String secondStepStr = "([a-z0-9-_\\.])+";
        Pattern secondStepPattern = Pattern.compile(secondStepStr);
        Matcher matcher = secondStepPattern.matcher(new_id);
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        new_id = sb.toString();
        
        
        // 3 step
		while(new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}
        
		
        // 4 step
        if(new_id.startsWith(".")) {
        	new_id = new_id.substring(1, new_id.length());
        }
        if(new_id.endsWith(".")) {
        	new_id = new_id.substring(0, new_id.length()-1);
        }
        
        
        // 5 step
        if("".equals(new_id)) {
        	new_id = "a";
        }
        
        
        // 6 step
        if(new_id.length() >= 16) {
        	new_id = new_id.substring(0, 15);
            if(new_id.endsWith(".")) {
            	new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        
        
        // 7 step
        while(new_id.length() < 3) {
        	new_id += new_id.charAt(new_id.length()-1);
        }
        answer = new_id;
System.out.println("7 after answer:" + answer);
        return answer;
    }
    
	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		solution(new_id);	// bat.y.abcdefghi
		
		new_id = "z-+.^.";
		solution(new_id);	// z--
		
		new_id = "=.=";
		solution(new_id);	// aaa
		
		new_id = "123_.def";
		solution(new_id);	// 123_.def
		
		new_id = "abcdefghijklmn.p";
		solution(new_id);	// abcdefghijklmn
	}
}
