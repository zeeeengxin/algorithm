package leetcode;
import java.util.*;

public class LC636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int[] current = new int[n];
        Deque<int[]> stack = new LinkedList<>();
        for (String str : logs) {
            String[] parseStr = str.split(":");
            int[] curPair = new int[] {Integer.parseInt(parseStr[0]), Integer.parseInt(parseStr[2])};
            if (parseStr[1].equals("start")) {
                stack.push(curPair);
            } else {
                int[] startPair = stack.pop();
                int index = startPair[0];
                int lose = current[index];
                res[index] += curPair[1] + 1 - startPair[1] - lose;
                current[index] = 0; // reset lose
                if (!stack.isEmpty()) {
                    int passLoseIndex = stack.peek()[0];
                    current[passLoseIndex] += curPair[1] + 1 - startPair[1];
                }
            }
        }
        return res;
    }
}
