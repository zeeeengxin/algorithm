package other;
import java.util.List;
import java.util.ArrayList;

public class RandomFibo {
    public static int randomFibonacci (int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(1);
        while (nums.get(nums.size() - 1) + nums.get(nums.size() - 2) <= n) {
            nums.add(nums.get(nums.size() - 1) + nums.get(nums.size() - 2));
        }
        int total = nums.size();
        System.out.println(nums);
        return nums.get((int)(Math.random() * total));
    }
    public static String fiboString(int num) {
        int a = 0, b = 1;
        for (int i = 2; i <= num; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        StringBuilder sb = new StringBuilder();
        char c = (char)('a' + num - 1);
        for (int i = 0; i < b; i++) {
            sb.append(c);
        }
        return sb.toString();
    }


}
