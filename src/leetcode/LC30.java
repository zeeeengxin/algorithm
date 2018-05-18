package leetcode;
import java.util.*;

public class LC30 {
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        Map<String, Integer> map = getMap(words);
        int uniqWords = map.size();
        int wordLen = words[0].length();
        int windowLen = words.length * wordLen;
        for (int i = 0; i < wordLen; i++) {
            int match = 0;
            Map<String, Integer> curMap = new HashMap<>();
            curMap.putAll(map);
            int left = i, right = i + wordLen;
            while (right <= s.length()) {
                String curWord = s.substring(right-wordLen, right);
                Integer count = curMap.get(curWord);
                if (count == null) {
                    left = right;
                    right = right + wordLen;
                    match = 0;
                    curMap.putAll(map);
                } else {
                    curMap.put(curWord, count-1);
                    if (count == 1) match++;
                    if (match == uniqWords) {
                        res.add(left);  
                    }
                    if (right - left == windowLen) {                    
                        String leftWord = s.substring(left, left+wordLen);
                        count = curMap.get(leftWord);
                        curMap.put(leftWord, count+1);
                        if (count == 0) match--;
                        left += wordLen;
                    } 
                    right += wordLen;              
                }
            } 
        }
        return res;
    }
    
    private static Map<String, Integer> getMap(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = map.get(word); // getOrDefault
            if (count == null) map.put(word, 1);
            else map.put(word, count + 1);
        }
        return map;
    }
}
