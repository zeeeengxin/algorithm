package leetcode;
import java.util.*;

public class LC56 {
	private class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() <= 0) return res;
        Collections.sort(intervals, new intervalComparator());
        for (Interval range : intervals) {
            int s = range.start, e = range.end;
            if (res.isEmpty() || res.get(res.size() - 1).end < s) {
                res.add(new Interval(s, e));
            } else {
                if (e > res.get(res.size() - 1).end) {
                    res.get(res.size() - 1).end = e;
                }
            }
        }   
        return res;
    }
    private class intervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval one, Interval two) {
            if (one.start == two.start) {
                return 0;      
            }
            return one.end < two.end ? -1 : 1;          
        }
    }
}
