package leetcode;
import java.util.*;

public class LC248 {
    class Solution {
        int[] multiplier;
        int[] numPerLevel;
        private void createNumPerLevelArr(int len) {
            numPerLevel = new int[len];
            numPerLevel[0] = 0;
            if (len > 1) numPerLevel[1] = 3;
            for (int i = 2; i < len; i++) {
                numPerLevel[i] = 4 * multiplier[i - 2];
            }
        }
        private void createMultiplierArr(int len) {
            multiplier = new int[len];
            multiplier[0] = 1;
            if (len > 1) multiplier[1] = 3;
            for (int i = 2; i < len; i++) {
                multiplier[i] = multiplier[i - 2] * 5;
            }
        }
        private boolean isBadRange(String low, String high) {
            if (low.charAt(0) == '-' && high.charAt(0) == '-')
                return false;
            if (low.charAt(0) == '-' && high.charAt(0) != '-')
                return false;
            if (low.charAt(0) != '-' && high.charAt(0) == '-')
                return true;
            if (high.length() < low.length())
                return true;
            if (high.length() > low.length())
                return false;
            return !isStrSmallerOrEqual(low, high);
        }
        public int strobogrammaticInRange(String low, String high) {
            if(isBadRange(low, high)) {
                return 0;
            }
            int larger = smallerOrEqual(high);
            int smaller = smallerOrEqual(low);

            if (isStrobo(low)) {
                return larger - smaller + 1;
            } else {
                return larger - smaller;
            }
        }
        private boolean isStrobo(String num) {
            int i = 0;
            int j = num.length() - 1;
            char[] arr = num.toCharArray();
            while (i < j) {
                if (isNotStroboDigit(arr[i]) || isNotStroboDigit(arr[j])) {
                    return false;
                }
                if (arr[i] == '6' && arr[j] != '9')
                    return false;
                if (arr[i] == '9' && arr[j] != '6')
                    return false;
                if (arr[i] != arr[j])
                    return false;
                i++; j--;
            }
            return true;
        }
        private boolean isNotStroboDigit(char c) {
            if (c >= '2' && c <= '5' || c == '7') {
                return true;
            }
            return false;
        }
        private int smallerOrEqual(String num) {
            if (num.charAt(0) == '-') {
                return 0;
            }
            if (multiplier == null) {
                createMultiplierArr(num.length());
            }
            if (numPerLevel == null) {
                createNumPerLevelArr(num.length());
            }
            List<String> sameLen = getSameLenSmallerOrEqual(num.length());
            int count = 0;
            for (String s : sameLen) {
                if ((s.charAt(0) == '0' && s.length() == 1 || s.charAt(0) != '0') && (isStrSmallerOrEqual(s, num)))
                    count++;
            }
            return getLessDigitSum(num.length() - 1) + count;
        }
        private boolean isStrSmallerOrEqual(String str, String compared) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < compared.charAt(i)) {
                    return true;
                } else if (str.charAt(i) > compared.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        private List<String> getSameLenSmallerOrEqual(int len) {
            List<String> res= new ArrayList<>();
            if (len == 1) {
                res.addAll(Arrays.asList("0", "1", "8"));
                return res;
            }
            if (len == 2) {
                res.addAll(Arrays.asList("00", "11", "88", "69", "96"));
                return res;
            }
            for(String s : getSameLenSmallerOrEqual(len - 2)) {
                res.add("0" + s + "0");
                res.add("1" + s + "1");
                res.add("6" + s + "9");
                res.add("8" + s + "8");
                res.add("9" + s + "6");
            }
            return res;
        }
        private int getLessDigitSum(int len) {
            int res = 0;
            for (int i = 0; i <= len; i++) {
                res += numPerLevel[i];
            }
            return res;
        }
    }
}
