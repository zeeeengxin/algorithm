package other;

import java.util.HashSet;
import java.util.Set;

//input: <div><label>username<sup>*</sup></label><input type="text" name="username"/><span>field is required</span></div>
		
// only <div>, <label> or <input> are valid, all the other tags are invalid
// output: <div><label>username*</label><input type="text" name="username"/>field is required</div>

public class DeleteTags {
	public static String deleteTags(String s) {
		if (s == null || s.length() == 0) return null;
		int i = 0;
		Set<String> set = getValidTag();
		StringBuilder res = new StringBuilder();
		while (i < s.length()) {
			if (s.charAt(i) != '<') {
				res.append(s.charAt(i));				
			} else {
				StringBuilder cur = new StringBuilder();
				while (i < s.length() && s.charAt(i) != '>') {
					cur.append(s.charAt(i));
					i++;
				}
				cur.append('>');
				if (set.contains(cur.toString()) || cur.length() > 5 && cur.substring(0, 6).equals("<input")) {
					res.append(cur);
				}
			}
			i++;
		}
		return res.toString();
	}
	private static Set<String> getValidTag() {
		Set<String> set = new HashSet<>();
		set.add("<div>");
		set.add("</div>");
		set.add("<label>");
		set.add("</label>");	
		return set;
	}
}
