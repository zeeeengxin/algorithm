package leetcode;
import java.util.*;

public class LC218 {
        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> res = new ArrayList<>();
            if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
                return res;
            }
            Point[] list = getPoints(buildings);
            Arrays.sort(list, new PointComparator());
            TreeMap<Integer, Integer> q = new TreeMap<>(Collections.reverseOrder());
            q.put(0, 1);
            for (Point p : list) {
                if (p.isStart) {
                    if (p.y > q.firstKey()) {
                        res.add(new int[] {p.x, p.y});
                    }
                    Integer count = q.getOrDefault(p.y, 0);
                    q.put(p.y, count + 1);
                } else {
                    Integer count = q.get(p.y);
                    if (count == 1) {
                        q.remove(p.y);
                    } else {
                        q.put(p.y, count - 1);
                    }
                    if (p.y > q.firstKey()) {
                        res.add(new int[] {p.x, q.firstKey()});
                    }
                }
            }
            return res;
        }
        private Point[] getPoints(int[][] buildings) {
            Point[] list = new Point[buildings.length * 2];
            for (int i = 0; i < buildings.length; i++) {
                list[i * 2] = new Point(buildings[i][0], buildings[i][2], true);
                list[i * 2 + 1] = new Point(buildings[i][1], buildings[i][2], false);
            }
            return list;
        }
        class Point {
            int x;
            int y;
            boolean isStart;
            Point(int x, int y, boolean isStart) {
                this.x = x;
                this.y = y;
                this.isStart = isStart;
            }
        }
        class PointComparator implements Comparator<Point> {
            @Override
            public int compare(Point a, Point b) {
                if (a.x < b.x) {
                    return -1;
                }
                if (a.x > b.x) {
                    return 1;
                }
                if (a.isStart && b.isStart) {
                    return a.y > b.y ? -1 : 1;
                } else if (!a.isStart && !b.isStart) {
                    return a.y < b.y ? -1 : 1;
                } else {
                    return a.isStart ? -1 : 1;
                }
            }
        }

}
