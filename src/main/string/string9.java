// https://leetcode.com/problems/palindrome-number/
// 9. Palindrome Number
package main.string;

public class string9 {
	
    public static boolean isPalindrome(int x) {
        boolean answer = false;
        if(x >= 0) {
        	int xReverse = 0;
        	int xSave = x;
        	while(x > 0) {
        		xReverse *= 10;
        		xReverse += x%10;
        		x /= 10;
        	}
        	if(xSave == xReverse) {
        		answer = true;
        	}
        }
//System.out.println("answer:" + answer);
        return answer;
    }
    
	public static void main(String[] args) {
		int x = 121;
		isPalindrome(x);	// true
		
		x = -121;
		isPalindrome(x);	// false
		
		x = 10;
		isPalindrome(x);	// false
		
		x = -101;
		isPalindrome(x);	// false
	}
}
