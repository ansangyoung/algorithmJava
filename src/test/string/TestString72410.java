// https://programmers.co.kr/learn/courses/30/lessons/72410
// 신규 아이디 추천
package test.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestString72410 {
	private final main.string.string72410 string72410 = new main.string.string72410();
	
	@Test
	void TestSoluton() {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		String expectStr = "bat.y.abcdefghi";
		String resRetStr = string72410.solution(new_id);
		assertEquals(expectStr, resRetStr);
		
		new_id = "z-+.^.";
		expectStr = "z--";
		resRetStr = string72410.solution(new_id);
		assertEquals(expectStr, resRetStr);
		
		new_id = "=.=";
		expectStr = "aaa";
		resRetStr = string72410.solution(new_id);
		assertEquals(expectStr, resRetStr);
		
		new_id = "123_.def";
		expectStr = "123_.def";
		resRetStr = string72410.solution(new_id);
		assertEquals(expectStr, resRetStr);
		
		new_id = "abcdefghijklmn.p";
		expectStr = "abcdefghijklmn";
		resRetStr = string72410.solution(new_id);
		assertEquals(expectStr, resRetStr);
		//assertEquals(expectStr, "false 테스트");
	}
}
