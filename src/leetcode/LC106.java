package leetcode;
import java.util.*;

public class LC106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || inorder.length != postorder.length) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        // create HashMap for inorder
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        stack.push(root);
        for (int i = postorder.length - 2; i >= 0; i--) {
            int curIndex = map.get(postorder[i]);
            TreeNode cur = new TreeNode(postorder[i]);
            if (curIndex > map.get(stack.peek().val)) {
                stack.peek().right = cur;
            } else {
                TreeNode p = null;
                while (!stack.isEmpty() && curIndex < map.get(stack.peek().val)) {
                    p = stack.pop();
                }
                p.left = cur;                
            }
            stack.push(cur.left);
        }
        return root;
    }
}
