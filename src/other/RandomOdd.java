package other;
import java.util.*;

public class RandomOdd {
    public static int randomOdd(int start, int end) {
        if (start > end || start == end && start % 2 == 0) {
            throw new IllegalArgumentException("Invalid range!");
        }
        // [odd, even]
        start = start % 2 == 0 ? start + 1: start;
        end = end % 2 == 0 ? end : end + 1;
        int n = (end - start + 1) / 2;
        return (int)(Math.random() * n) * 2 + start;
    }
}
