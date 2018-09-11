package leetcode;
import java.util.*;

public class LC187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) return new ArrayList<String>();
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0); map.put('C', 1); map.put('G', 2); map.put('T', 3);
        int num = 0;
        for (int i = 0; i < 9; i++) {
            num = (num << 2) | map.get(s.charAt(i));
        }
        for (int i = 9; i < s.length(); i++) {
            num = ((num & 0x3ffff) << 2) | map.get(s.charAt(i));
            if (!set.add(num)) {
                res.add(s.substring(i - 9, i + 1));
            }
        }
        return new ArrayList<String>(res);
    }
}
