// https://leetcode.com/problems/palindrome-number/
// 9. Palindrome Number
package test.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestString9 {
	private final main.string.string9 string9 = new main.string.string9();
	
	@Test
	void TestSoluton() {
		int x = 121;
		boolean expectBoolean = true;
		boolean resRetBoolean = string9.isPalindrome(x);
		assertEquals(expectBoolean, resRetBoolean);
		
		x = -121;
		expectBoolean = false;
		resRetBoolean = string9.isPalindrome(x);
		assertEquals(expectBoolean, resRetBoolean);
		
		x = 10;
		expectBoolean = false;
		resRetBoolean = string9.isPalindrome(x);
		assertEquals(expectBoolean, resRetBoolean);
		
		x = -101;
		expectBoolean = false;
		resRetBoolean = string9.isPalindrome(x);
		assertEquals(expectBoolean, resRetBoolean);
	}
}