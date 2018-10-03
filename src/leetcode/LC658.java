package leetcode;
import java.util.*;

public class LC658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int right = firstLarger(arr, x);
        int left = right - 1;
        for (int i = 0; i < k; i++) {
            int leftDiff = left >= 0 ? x - arr[left] : Integer.MAX_VALUE;
            int rightDiff = right < arr.length ? arr[right] - x : Integer.MAX_VALUE;
            if (leftDiff <= rightDiff) {
                res.add(arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
        }
        Collections.sort(res);
        return res;
    }
    // first one larger than x
    private int firstLarger(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
