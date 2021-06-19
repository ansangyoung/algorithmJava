// https://leetcode.com/problems/bulb-switcher-iv/
// 1529. Bulb Switcher IV
package main.string;

public class string1529 {

	public static int minFlips(String target) {
		int res = target.charAt(0) == '0'? 0 : 1;
		int targetLen = target.length();
		for (int i = 0; i < targetLen - 1; i++) {
			if (target.charAt(i) != target.charAt(i + 1)) {
				res++;
			}
		}
//System.out.println("target:" + target + ", res:" + res);
//System.out.println("");
		return res;
	}

	public static void main(String[] args) {
		String target = "10111";
		minFlips(target); // 3

		target = "101";
		minFlips(target); // 3

		target = "00000";
		minFlips(target); // 0

		target = "001011101";
		minFlips(target); // 5
		
		target = "001111";
		minFlips(target); // 1
		
		target = "11000";
		minFlips(target); // 2
		
		target = "010011101";
		minFlips(target); // 5
		
		target = "00100111000";
		minFlips(target); // 4		
	}
}
