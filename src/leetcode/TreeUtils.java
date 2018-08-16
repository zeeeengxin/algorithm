package leetcode;
import java.util.*;

public class TreeUtils {
	public static TreeLinkNode createTree(char[] s) {
		// assume valid s
		Queue<TreeLinkNode> q = new LinkedList<>();
		TreeLinkNode root = new TreeLinkNode(s[0] - '0');
		q.offer(root);	
		int i = 1;
		while (i < s.length) {
			TreeLinkNode cur = q.poll();
			if (s[i] != '#') {
				cur.left = new TreeLinkNode(s[i] - '0');
				q.offer(cur.left);				
			}
			i++;
			if (i < s.length && s[i] != '#') {
				cur.right = new TreeLinkNode(s[i] - '0');
				q.offer(cur.right);
			}
			i++;
		}
		return root;
	}
}
