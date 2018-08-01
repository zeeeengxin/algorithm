package leetcode;
import java.util.*;

public class LC95 {
	// Solution 1: my 2D-DP. Also shared with comments on:
	// https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/155810/Share-my-Java-DP-solution-(1ms)-with-comments
	public List<TreeNode> generateTrees(int n) {        
        if (n == 0) return new ArrayList<TreeNode>(); // corner case		
        List<TreeNode>[][] dp = new List[n + 2][n + 2];							
        for (int i = 1; i <= n; i++) { // mark the end
            for (int j = i; j >= 1; j--) { // mark the start, we want to calculate dp[j][i]
                List<TreeNode> cur = new ArrayList<>();
                for (int k = j; k <= i; k++) { // from number j(start) to i(end), we want each number to be the root once
                	if (dp[j][k - 1] == null) { // or when j > k - 1, that's the only situation where a previous dp hasn't been calculated yet, the left subtree is null
                		dp[j][k - 1] = new ArrayList<TreeNode>();
                		dp[j][k - 1].add(null);
                	}
			if (dp[k + 1][i] == null) { // or when k + 1 > i, that's when the right subtree is null
                		dp[k + 1][i] = new ArrayList<TreeNode>();
                		dp[k + 1][i].add(null);
                	}
                	List<TreeNode> left = dp[j][k - 1];  // get the left subtrees from dp table              	
                	List<TreeNode> right = dp[k + 1][i]; // get the right subtrees from dp table
                	for (TreeNode leftNode : left) {
                		for (TreeNode rightNode : right) {
                        	TreeNode root = new TreeNode(k);
                        	root.left = leftNode;
                        	root.right = rightNode;
                        	cur.add(root); // add this possibility to current List of treenodes
                		}
                	}
                }
                dp[j][i] = cur; // we get dp[j][i] now!
            }
        }    
        return dp[1][n];
    }   
	
	// Solution 2: recursion
	public List<TreeNode> generateTrees2(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return helper(1, n);      
    }
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtree = helper(start, i - 1);
            List<TreeNode > rightSubtree = helper(i + 1, end);
            for (TreeNode left : leftSubtree) {
                for (TreeNode right : rightSubtree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
