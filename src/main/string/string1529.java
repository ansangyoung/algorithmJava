// https://leetcode.com/problems/bulb-switcher-iv/
// 1529. Bulb Switcher IV
package main.string;

public class string1529 {

	public static int minFlips(String target) {
		int res = 0;
		
		int lastChgIdx = 0;
		int dupChk = 0;
		int targetLen = target.length();
		for (int i = 0; i < targetLen - 1; i++) {
			if (target.charAt(i) != target.charAt(i + 1)) {
				res++;
				lastChgIdx = i;
				if(i == 0 || i == targetLen - 2) {
					dupChk++;
				}
			}
		}
		
		// case1: 0111110, res == 2, dupChk == 2
		res += dupChk == 2 ? --dupChk : dupChk;
		
		// case2: 000011111, res == 1
		if(dupChk == 0) {
			if(lastChgIdx < targetLen - 2) {
				res++;
			}
		}
		
		// startwith 0인 case는 최초 1이 나오기 전까지의 0은 제외. 
		if (targetLen > 0 && target.charAt(0) == '0' && res > 0) {
			res--;
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
