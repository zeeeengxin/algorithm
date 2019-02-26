package leetcode;
import java.util.*;

public class LC251 {

    Iterator<Integer> colIterator;
    Iterator<int[]> rowIterator;

    public LC251(int[][] v) {
        if (v == null) return;
        rowIterator = Arrays.asList(v).iterator();
        while(rowIterator.hasNext() && colIterator == null) {
            int[] newRow = rowIterator.next();
            if (newRow != null) {
                List<Integer> l = new ArrayList<>();
                for (int i : newRow) {
                    l.add(i);
                }
                colIterator = l.iterator();
            }
        }
    }

    public int next() {
        hasNext();
        // condition: only call next() when we know that it has next element
        return colIterator.next();
    }

    public boolean hasNext() {
        if (colIterator == null) return false; // int[][] v = []
        while (rowIterator.hasNext() && !colIterator.hasNext()) {
            int[] newRow = rowIterator.next();
            if (newRow != null) {
                List<Integer> l = new ArrayList<>();
                for (int i : newRow) {
                    l.add(i);
                }
                colIterator = l.iterator();
            }
        }
        if (!rowIterator.hasNext() && !colIterator.hasNext()) {
            return false;
        }
        return true;
    }
}
