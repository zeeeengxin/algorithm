package leetcode;

public class LC29 {
	public static int divide(int dividend, int divisor) {
		int sign = 1;
		if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
			sign = -1;
		}
		long m = Math.abs((long)dividend), n = Math.abs((long)divisor);
		System.out.println(m + " " + n);
		long res = 0;
		if (m < n) return 0;
		while (m >= n) {
			long tmp = n, p = 1;
			while (m >= (tmp << 1)) {
				tmp = tmp << 1;
				p = p << 1;
			}
			m -= tmp;
			res += p;
		}
		res *= sign;
		return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
	}

}
