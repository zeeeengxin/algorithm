package leetcode;
import java.util.*;

public class LC246 {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() <= 0) return true;
        if (num.charAt(0) == '-') return false;
        char[] array = num.toCharArray();
        Set<Character> bad = new HashSet<>();
        bad.add('2');
        bad.add('3');
        bad.add('4');
        bad.add('5');
        bad.add('7');
        for (int l = 0, r = array.length - 1; l <= r; l++, r--) {

            if (!match(array[l], array[r], bad)) {

                return false;
            }
        }
        return true;
    }
    private boolean match(char a, char b, Set<Character> bad) {
        if (bad.contains(a) || bad.contains(b)) {
            return false;
        }

        if (a == '6') {
            a = '9';
        } else if (a == '9') {
            a = '6';
        }
        return a == b;
    }
}
