package leetcode;

import java.util.*;
import other.*;

public class Main {
	public static void main(String[] args) {
		char[] arr = {'3','1','2','1','3','3','4','5','3','6','7'};
		TreeNode root = TreeUtils.createBinaryTree(arr);
		TreeUtils.printTreeLevelOrder(root);

        System.out.println(NumAppearMostLevelInTree.numberAppearMost(root));

	}
	
}
