package leetcode;

import java.util.*;

public class LC17 {
	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.add("");
		for (int i = 0; i < digits.length(); i++) {
			List<String> tmp = new ArrayList<>();
			String chars = map[digits.charAt(i) - '0'];
			for (int c = 0; c < chars.length(); c++) {
				for (int j = 0; j < res.size(); j++) {
					tmp.add(res.get(j) + chars.charAt(c));
				}
			}
			//System.out.println(tmp.toString());

			res = tmp;
		}
		return res;
	}
}
