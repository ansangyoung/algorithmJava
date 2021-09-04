// https://leetcode.com/problems/replace-words/
// 648. Replace Words
package main.string;

import java.util.Arrays;
import java.util.List;

class Solution2 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String res = "";
        String[] sentenceLst = sentence.split(" ");
        
        for(String dicVal : dictionary) {
        	int sentenceLen = sentenceLst.length;
        	for(int i = 0; i < sentenceLen; i++) {
        		String sentenceVal = sentenceLst[i];
        		if(sentenceVal.startsWith(dicVal)) {
        			sentenceLst[i] = dicVal;
        		}
        	}
        }
        
        for(String sentenceVal : sentenceLst) {
        	res += sentenceVal + " ";
        }
        res = res.substring(0, res.length() - 1);
System.out.println("res:" + res);
        return res;
    }
}

public class string648 {
	public static void main(String[] args) {
		List<String> dictionary = Arrays.asList("cat", "bat", "rat");
		String sentence = "the cattle was rattled by the battery";
		
		Solution2 soultion = new Solution2();
		soultion.replaceWords(dictionary, sentence);	// "the cat was rat by the bat"
		
		dictionary = Arrays.asList("a", "b", "c");
		sentence = "aadsfasf absbs bbab cadsfafs";
		soultion.replaceWords(dictionary, sentence);	// "a a b c"
		
		dictionary = Arrays.asList("a", "aa", "aaa", "aaaa");
		sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		soultion.replaceWords(dictionary, sentence);	// "a a a a a a a a bbb baba a"
		
		dictionary = Arrays.asList("catt","cat","bat","rat");
		sentence = "the cattle was rattled by the battery";
		soultion.replaceWords(dictionary, sentence);	// "the cat was rat by the bat"
		
		dictionary = Arrays.asList("ac","ab");
		sentence = "it is abnormal that this solution is accepted";
		soultion.replaceWords(dictionary, sentence);	// "it is ab that this solution is ac"
	}
}