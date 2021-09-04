// https://leetcode.com/problems/partition-labels/
// 763. Partition Labels
package main.string;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public List<Integer> partitionLabels(String s) {
    	List<Integer> res = new ArrayList<Integer>();
    	
    	int sLen = s.length();
    	int i = 0;
    	for(; i < sLen;) {
    		int resVal = i;
    		char chkLetter = s.charAt(i);
    		int lastIdx = s.lastIndexOf(chkLetter);
    		for(int j = i + 1; j < lastIdx; j++) {
    			char chkPartLetter = s.charAt(j);
    			int lastPartIdx = s.lastIndexOf(chkPartLetter);
    			if(lastIdx < lastPartIdx) {
    				lastIdx = lastPartIdx;
    			}
    		}
    		i = lastIdx + 1;
    		res.add(i - resVal);
    	}
System.out.println("res:" + res);
    	return res;
    }
}

public class string763 {
	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		
		Solution3 soultion = new Solution3();
		soultion.partitionLabels(s);	// [9, 7, 8]
		
		s = "caedbdedda";
		soultion.partitionLabels(s);	// [1, 9]
	}
}