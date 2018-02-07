package leetcode;

public class LC32 {
	public static int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        int[] longest = new int[s.length()];
        int max = 0;
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
        	if (array[i] == '(') continue;
            if (array[i - 1] == '(') {
                    int prev = i - 2 >= 0 ? longest[i - 2] : 0;
                    longest[i] = prev + 2;          
            } else if (longest[i - 1] != 0){
            	int prevIndex = i - longest[i - 1] - 1;
            	if (prevIndex >= 0 && array[prevIndex] == '(') {            
            		longest[i] = longest[i - 1] + 2;
            		if (prevIndex - 1 >= 0)
            			longest[i] += longest[prevIndex - 1]; 
            	}
            }
            System.out.println(i + " " + longest[i]);
            max = Math.max(max, longest[i]);
        }
        return max;
    }
}
