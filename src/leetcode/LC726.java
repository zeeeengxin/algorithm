package leetcode;
import java.util.*;

public class LC726 {
    public static String countOfAtoms(String formula) {
        if (formula == null || formula.length() == 0) {
            return formula;
        }
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        Map<String, Integer> cur = new TreeMap<>();
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (Character.isUpperCase(c)) {
                StringBuilder atom = new StringBuilder();
                atom.append(c);
                while (i < formula.length() - 1 && Character.isLowerCase(formula.charAt(i + 1))) {
                    atom.append(formula.charAt(i + 1));
                    i++;
                }
                int n = 0;
                while (i < formula.length() - 1 && Character.isDigit(formula.charAt(i + 1))) {
                    n = n * 10 + formula.charAt(i + 1) - '0';
                    i++;
                }
                int count = cur.getOrDefault(atom.toString(), 0);
                if (n == 0) {
                    cur.put(atom.toString(), count + 1);
                } else {
                    cur.put(atom.toString(), count + n);
                }
            } else if (c == '(') {
                stack.push(cur);
                cur = new TreeMap<>();
            } else if (c == ')') {
                int n = 0;
                while (i < formula.length() - 1 && Character.isDigit(formula.charAt(i + 1))) {
                    n = n * 10 + formula.charAt(i + 1) - '0';
                    i++;
                }
                Map<String, Integer> tmp = new TreeMap<>();
                if (n > 0) {
                    for (Map.Entry<String, Integer> e : cur.entrySet()) {
                        tmp.put(e.getKey(), e.getValue() * n);
                    }
                    cur = tmp;
                }
                tmp = stack.pop();
                for (Map.Entry<String, Integer> e : tmp.entrySet()) {
                    Integer count = cur.getOrDefault(e.getKey(), 0);
                    cur.put(e.getKey(), count + e.getValue());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : cur.entrySet()) {
            sb.append(e.getKey());
            if (e.getValue() > 1) {
                sb.append(e.getValue());
            }
        }
        return sb.toString();
    }
}
