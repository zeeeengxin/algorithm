package leetcode;
import java.util.*;

public class LC93 {
	//Solution 1:
	public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<String>();
        helper1(s, 0, "", res);
        return res;
    }
    public void helper1(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) res.add(out);
            return;
        }
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            int val = Integer.parseInt(s.substring(0, k));
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper1(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }
    }
    // Solution 2:
	public static List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) return res;
        StringBuilder sb = new StringBuilder();
        helper2(res, sb, 0, s, 0);		
        return res;
    }
    private static void helper2(List<String> res, StringBuilder sb, int index, String s, int times) {
        if (index >= s.length()) return;
        if (times == 3) {
            int num = Integer.parseInt(s.substring(index));
            if (Integer.toString(num).equals(s.substring(index)) && num >= 0 && num <= 255) {
                sb.append(num);
                res.add(new String(sb));
                sb.delete(sb.length() - (s.length() - index), sb.length());                
            } 
            return;
        }  
        sb.append(s.substring(index, index + 1));
		sb.append('.');
		helper2(res, sb, index + 1, s, times + 1);
		sb.delete(sb.length() - 2, sb.length());		
        if (index + 1 < s.length() && s.charAt(index) != '0') {
        	sb.append(s.substring(index, index + 2));
    		sb.append('.');
    		helper2(res, sb, index + 2, s, times + 1);
    		sb.delete(sb.length() - 3, sb.length());
        }
        if (index + 2 < s.length() && s.charAt(index) != '0') {
	        int num =  Integer.parseInt(s.substring(index, index + 3));
	        if (num >= 0 && num <= 255) {
	            sb.append(num);
	            sb.append('.');
	            helper2(res, sb, index + 3, s, times + 1);
	            sb.delete(sb.length() - 4, sb.length());
	        }
        }
    } 
}
