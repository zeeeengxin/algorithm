package other;
import java.util.*;

public class SortByFreq {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            Integer count = freqMap.getOrDefault(num, 0);
            freqMap.put(num, count + 1);
        }
        Set<Map.Entry<Integer, Integer>> set = new TreeSet<>(new myComparator());
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            set.add(e);
        }
        for (Iterator<Map.Entry<Integer, Integer>> it = set.iterator(); it.hasNext();) {
            Map.Entry<Integer, Integer> entry = it.next();
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.println(entry.getKey());
            }
        }
    }
    private static class myComparator implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
            if (e1.getValue() == e2.getValue()) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e1.getValue() < e2.getValue() ? -1 : 1;
        }
    }
}
