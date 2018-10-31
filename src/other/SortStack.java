package other;
import java.util.*;

public class SortStack {
    public static void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        for (int i = s1.size(); i > 0; i--) {
            Integer max = Integer.MIN_VALUE;
            for (int j = i; j > 0; j--) {
                if (s1.get(s1.size() - 1) > max) {
                    s2.add(max);
                    max = s1.remove(s1.size() - 1);
                } else {
                    s2.add(s1.remove(s1.size() - 1));
                }
            }
            s1.add(max);
            while (!s2.isEmpty()) {
                s1.add(s2.remove(s2.size() - 1));
            }
        }
    }
}



