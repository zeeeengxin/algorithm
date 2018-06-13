package leetcode;
import java.util.*;

public class LC57 {
	private class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int n = intervals.size();       
        int i = 0;
        boolean merged = false;
        while (i < n) {
            if (intervals.get(i).end < newInterval.start || merged) {
                res.add(intervals.get(i++));
                continue;
            } 
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            while (i < n && intervals.get(i).end < newInterval.end) {
                i++;
            }            
            if (i < n && newInterval.end >= intervals.get(i).start) {
            	newInterval.end = intervals.get(i).end;
                i++;
            }
            res.add(newInterval);
            merged = true;
        }
        if (!merged) {
            res.add(newInterval); 
        }
        return res;
    }
}
