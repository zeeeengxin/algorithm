package other;

public class ShiftString {
    public static void shift(String s, int left, int right) {
        int n = s.length();
        if (left == right) {
            System.out.println(s);
        } else if (left < right) {
            shift2(s, (right - left) % n);
        } else {
            shift2(s, n - (left - right) % n);
        }
    }
    private static void shift2(String s, int i) {
        int n = s.length();
        char[] arr = s.toCharArray();
        reverse(arr, 0, n - 1);
        reverse(arr, 0, i - 1);
        reverse(arr, i, n - 1);
        System.out.print(new String(arr));
    }
    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char c = arr[left];
            arr[left] = arr[right];
            arr[right] = c;
            left++;
            right--;
        }
    }
}
