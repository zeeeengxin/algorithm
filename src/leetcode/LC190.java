package leetcode;

public class LC190 {
    public static int reverseBits(int n) {
        for (int left = 31, right = 0; left > right; left--, right++) {
            if (((n >>> left) & 1) != ((n >>> right) & 1)) {
                n ^= ((1 << right) | (1 << left));
            }
        }
        return n;
    }
}
