package other;
import java.util.*;

public class SimpleQuery {
    public static int[] query(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] res = new int[arr2.length];
        for (int i = 0; i < arr2.length; i++) {
            int left = 0;
            if (i > 0) {
                left = res[i-1];
            }
            int index = find(arr1, arr2[i], left, arr1.length);
            res[i] = index;
        }
        System.out.print(Arrays.toString(res));
        return res;
    }
    private static int find(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
