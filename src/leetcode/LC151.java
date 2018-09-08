package leetcode;

public class LC151 {
    // in-place
    public static String reverseWords(String s) {
        char[] array = s.toCharArray();
        reverse(array, 0, array.length - 1);
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            while (i < array.length && array[i] == ' ') {
                i++;
            }
            if (i >= array.length) break;
            int start = i;
            while (i < array.length && array[i] != ' ') {
                i++;
            }
            reverse(array, start, i - 1);
            if (end != 0) {
                array[end] = ' ';
                end++;
            }
            for (int j = start; j < i; j++) {
                array[end] = array[j];
                end++;
            }
        }
        return new String(array, 0, end);
    }
    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++; end--;
        }
    }
}
