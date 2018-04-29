package leetcode;

import java.util.*;

public class LC127 {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<String>(wordList); 
		// HashSet<>(Collection) as constructor
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		dict.remove(beginWord);
		int res = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				String word = q.poll();
				if (word.equals(endWord)) return res;
				for (int j = 0; j < word.length(); j++) {
					char[] array = word.toCharArray();
					for (char replace = 'a'; replace <= 'z'; replace++) {
						if (replace == array[j]) continue;
						array[j] = replace;
						String str = new String(array);
						if (dict.remove(str)) {
							q.offer(str);
						}
					}
				}
			}
			res++;
		}
		return 0;
	}

}
