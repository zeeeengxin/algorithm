package leetcode;

import java.util.*;

import javafx.beans.property.SimpleListProperty;
import other.*;

public class Main {
	public static void main(String[] args) {
		//char[] arr = {'3','1','2','1', '1', '4'};
		//TreeNode root = TreeUtils.createBinaryTree(arr);
        //TreeUtils.printTreeLevelOrder(root);
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {0,1,3,6,7};

        //for (int i = 0; i < 10; i++)
        String[] a = {"practice","makes","perfect","coding","makes"};

        LC244 test = new LC244(a);

        int res = test.shortest("coding", "practice");
        System.out.print(res);
    }

}
