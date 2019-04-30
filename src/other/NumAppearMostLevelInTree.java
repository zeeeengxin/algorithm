package other;

import java.util.*;
import leetcode.*;

public class NumAppearMostLevelInTree {
	public static Integer numberAppearMost(TreeNode root) {
		if (root == null) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		map.put(root.val, 1);
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (cur.left != null) {
					q.offer(cur.left);
					if (set.add(cur.left.val)) {
						Integer num = map.getOrDefault(cur.left.val, 0);
						map.put(cur.left.val, num + 1);
					}
				}
				if (cur.right != null) {
					q.offer(cur.right);
					if (set.add(cur.right.val)) {
						Integer num = map.getOrDefault(cur.right.val, 0);
						map.put(cur.right.val, num + 1);
					}
				}
			}
		}
		int maxNum = 0;
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxNum) {
				maxNum = entry.getValue();
				max = entry.getKey();
			}
		}
		return max;
	}

}
