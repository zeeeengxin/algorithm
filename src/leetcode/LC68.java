package leetcode;

import java.util.*;

public class LC68 {
	// much better solution:
	public List<String> fullJustify1(String[] words, int maxWidth) {        
		List<String> res = new LinkedList<>();
		for (int i = 0, w; i < words.length; i = w) {
			int len = -1; // don't need space for the last word
			for (w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) {
				len += words[w].length() + 1;
			}
			int evenlyDistributedSpace = 1;
			int extraSpace = 0;
			int numOfGaps = w - i - 1;

			if (w != i + 1 && w != words.length) {
				evenlyDistributedSpace = (maxWidth - len) / numOfGaps + 1; // + 1 is the default one space we put into len
				extraSpace = (maxWidth - len) % numOfGaps;
			}
			StringBuilder sb = new StringBuilder(words[i]);
			for (int j = i + 1; j < w; j++) {
				for (int s = 0; s < evenlyDistributedSpace; s++) {
					sb.append(' ');
				}
				if (extraSpace > 0) {
					sb.append(' ');
					extraSpace--;
				}
				sb.append(words[j]);
			}
			int remaining = maxWidth - sb.length(); // remaining space if left justified
			while (remaining > 0) {
				sb.append(' ');
				remaining--;
			}
			res.add(sb.toString());
		}
		return res;
	}
	
	// tedious solution:
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<int[]> count = getCount(words, maxWidth);
		List<String> res = new LinkedList<>();
		int w = 0;
		for (int i = 0; i < count.size() - 1; i++) {
			int numOfWord = count.get(i)[0];
			int numOfChar = count.get(i)[1];
			StringBuilder sb = new StringBuilder();
			if (numOfWord == 1) {
				sb.append(words[w]); 
				for (int j = numOfChar; j < maxWidth; j++) {
					sb.append(' ');
				}
			} else {
				int numOfSpace = (maxWidth - numOfChar) / (numOfWord - 1);
				int numOfExtraSpace = (maxWidth - numOfChar) % (numOfWord - 1);
				for (int j = 0; j < numOfWord; j++) {
					sb.append(words[w + j]);        		
					if (j != numOfWord - 1) {
						for (int k = 0; k < numOfSpace; k++) {
							sb.append(' ');
						}
						if (numOfExtraSpace > 0) {
							sb.append(' ');
							numOfExtraSpace--;
						}
					}
				}
			}
			w += numOfWord;
			res.add(sb.toString());
		}
		int numOfWord = count.get(count.size()-1)[0];
		int numOfChar = count.get(count.size()-1)[1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numOfWord; i++) {
			sb.append(words[w + i]);
			if (i != numOfWord - 1) {
				sb.append(' ');
			}
		}
		for (int i = numOfChar + numOfWord - 1; i < maxWidth; i++) {
			sb.append(' ');
		}
		res.add(sb.toString());
		//System.out.println(res);
		return res;
	}
	private List<int[]> getCount(String[] words, int maxWidth) {
		List<int[]> count = new LinkedList<>();
		int numOfWord = 0, numOfChar = 0;
		for (int i = 0; i < words.length; i++) {
			numOfWord++;
			numOfChar += words[i].length();
			if (numOfChar + numOfWord - 1 > maxWidth) {
				int[] nums = new int[] {numOfWord - 1, numOfChar - words[i].length()};
				count.add(nums);
				numOfWord = 1; numOfChar = words[i].length();
			}
			if (i == words.length - 1) {
				int[] nums = new int[] {numOfWord, numOfChar};
				count.add(nums);
			}
		}
		return count;
	}
}
