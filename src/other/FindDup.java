package other;

public class FindDup {
	// input: one two two three four four four six end end six
	
	// output: two two, four four four, end end		
	public static String findDup(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}	
		StringBuilder res = new StringBuilder();
		String prev = null;
		int i = 0;
		while (i < s.length()) {
			while (i < s.length() && s.charAt(i) == ' ') {
				i++;
			}
			StringBuilder cur = new StringBuilder();
			while (i < s.length() && s.charAt(i) != ' ') {
				cur.append(s.charAt(i));
				i++;
			}			
			if (cur.length() > 0) {				
				String curStr = cur.toString();
				if (curStr.equals(prev)) {
					if (res.length() > 0) {
						if (!res.substring(res.length() - curStr.length()).equals(curStr)) {
							res.append(", ");
							res.append(curStr);	
						}						
					} else {
						res.append(curStr);						
					}
					res.append(' ');
					res.append(curStr);
				} else {
					prev = curStr;
				}
			}
			System.out.println("res sb is " + res);
		}
		return res.toString();
	}
	
}
