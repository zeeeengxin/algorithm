package other;
import leetcode.*;
import java.util.*;

public class TreeToBST {
	// O(n) space O(nlogn) time
	public void convertToBST(TreeNode root) {
		if (root == null) {
			return;
		}
		List<Integer> nodes = new ArrayList<>();
		getNodes(root, nodes);
		Collections.sort(nodes);
		changeValue(root, nodes);
	}	
	private void changeValue(TreeNode root, List<Integer> nodes) {
		if (root == null) {
			return;
		}
		changeValue(root.right, nodes);
		root.val = nodes.get(nodes.size() - 1);
		nodes.remove(nodes.size() - 1);
		changeValue(root.left, nodes);
	}
	private void getNodes(TreeNode root, List<Integer> nodes) {
		if (root == null) {
			return;
		}
		getNodes(root.left, nodes);
		nodes.add(root.val);
		getNodes(root.right, nodes);
	}
	
	// O(height) space O(n^2) time
	boolean flag = true;
	TreeNode prev = null;
	public void convertToBST2(TreeNode root) {
		if (root == null) {
			return;
		}
		while (flag) {
			flag = false;
			prev = null;
			bubbleSort(root);
		}
	}
	private void bubbleSort(TreeNode root) {
		if (root == null) {
			return;
		}
		bubbleSort(root.left);
		if (prev != null && prev.val > root.val) {
			int tmp = prev.val;
			prev.val = root.val;
			root.val = tmp;
			flag = true;
		}
		prev = root;
		bubbleSort(root.right);
	}
}
