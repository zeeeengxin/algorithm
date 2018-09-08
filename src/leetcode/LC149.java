package leetcode;
import java.util.*;

public class LC149 {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int dup = 1;
            int sameX = 0;
            int sameY = 0;
            Map<Slope, Integer> count = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                } else if (points[i].x == points[j].x) {
                    sameX++;
                } else if (points[i].y == points[j].y) {
                    sameY++;
                } else {
                    Slope k = new Slope(points[i].y - points[j].y, points[i].x - points[j].x);
                    count.put(k, count.getOrDefault(k, 0) + 1);
                }
            }
            for (Map.Entry<Slope, Integer> entry : count.entrySet()) {
                //System.out.println(entry.getValue());
                res = Math.max(res, entry.getValue() + dup);
            }
            res = Math.max(res, sameX + dup);
            res = Math.max(res, sameY + dup);
        }
        return res;
    }
    private class Slope {
        final int a;
        final int b; // slope is a / b
        final boolean positive;
        Slope (int a, int b) {
            this.positive = (a / b > 0);
            a = Math.abs(a);
            b = Math.abs(b);
            int gcd = getGCD(a, b);
            this.a = a / gcd;
            this.b = b / gcd;
        }
        private int getGCD(int a, int b) {
            if (b == 0) {
                return a;
            }
            return getGCD(b, a % b);
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Slope)) return false;
            Slope s = (Slope) o;
            if (positive == s.positive && a == s.a && b == s.b) return true;
            return false;
        }
        @Override
        public int hashCode() {
            return a * 31 + b;
        }
    }

}
