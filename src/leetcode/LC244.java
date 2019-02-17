package leetcode;
import java.util.*;

public class LC244 {
    Map<String, List<Integer>> map = new HashMap<>();

    public LC244(String[] words) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<Integer>());
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> one = map.get(word1);
        List<Integer> two = map.get(word2);
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        while (i < one.size() && j < two.size()) {
            res = Math.min(res, Math.abs(one.get(i) - two.get(j)));
            if (one.get(i) < two.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
