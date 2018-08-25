package leetcode;
import java.util.*;

public class TreeUtils {
	public static TreeNode createBinaryTree(char[] s) {
		// assume valid s
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = new TreeNode(s[0] - '0');
		q.offer(root);	
		int i = 1;
		while (i < s.length) {
			TreeNode cur = q.poll();
			if (s[i] != '#') {
				cur.left = new TreeNode(s[i] - '0');
				q.offer(cur.left);				
			}
			i++;
			if (i < s.length && s[i] != '#') {
				cur.right = new TreeNode(s[i] - '0');
				q.offer(cur.right);
			}
			i++;
		}
		return root;
	}
	public static void printTreeInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printTreeInOrder(root.left);
		System.out.print(root.val);
		printTreeInOrder(root.right);
	}
	public static void printTreeLevelOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
                System.out.print(cur.val + " ");
				if (cur.left != null) {
					q.offer(cur.left);
				}
				if (cur.right != null) {
					q.offer(cur.right);
				}
			}
			System.out.println();
		}
	}
	public int countTotalNode(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = countTotalNode(root.left);
		int right = countTotalNode(root.right);
		return left + right + 1;
	}
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
