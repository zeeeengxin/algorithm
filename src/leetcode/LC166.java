package leetcode;
import java.util.*;

public class LC166 {
	public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if (denominator == 0) {
            return res.toString();
        }
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            res.append('-');
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        res.append(num / den);
        long remain = num % den;
        if (remain == 0) {
            return res.toString(); // result is an Integer
        }
        res.append('.');
        StringBuilder decimal = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>(); // <digit, index in stringbuilder>
        while (remain != 0) {
            Integer index = map.get(remain);
            if (index != null) {
                decimal.insert((int)index, '(');
                decimal.append(')');
                return res.append(decimal).toString();
            }          
            decimal.append(remain * 10 / den);
            map.put(remain, decimal.length() - 1);
            remain = remain * 10 % den;
        }
        return res.append(decimal).toString();
    }
	
	public static String repeatingDecimal(int denominator) {
        if (denominator == 0) {
            return "";
        }
        long den = Math.abs((long)denominator);
        long remain = 1 % den;
        if (remain == 0) {
            return "0";
        }
        StringBuilder decimal = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>(); // <digit, index in stringbuilder>
        while (remain != 0) {
            Integer index = map.get(remain);
            if (index != null) {           
                return decimal.substring(index);
            }          
            decimal.append(remain * 10 / den);
            map.put(remain, decimal.length() - 1);
            remain = remain * 10 % den;
        }
        return "0";
    }

}
