package leetcode;

public class LC28 {
	public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (isValid(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }
    private boolean isValid(String l, String s, int index) {
        for (int i = 0; i < s.length(); i++) {
            if (l.charAt(index + i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
