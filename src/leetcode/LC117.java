package leetcode;

public class LC117 {
	// not good
	// can use dummy head
	public static void connect(TreeLinkNode root) {
        TreeLinkNode start = root;
        while (start != null) {
	        TreeLinkNode cur = start;
	        while (cur != null) {
		        if (cur.left == null && cur.right == null) {
			        cur = cur.next;
			        continue;
		        }
		        if (cur.left != null && cur.right != null) {
			        cur.left.next = cur.right;
		        }
		        TreeLinkNode pre = cur.right == null ? cur.left : cur.right;
		        TreeLinkNode next = null;
		        cur = cur.next;		        
		        while (cur != null) {		        	
			        if (cur.left == null && cur.right == null) {
				        cur = cur.next;
			        } else {
				        next = cur.left == null ? cur.right : cur.left;
				        break;
			        }
		        }
		        pre.next = next;		      
	        }
	        while (start != null && start.left == null && start.right == null) {
		        start = start.next;
	        }
	        if (start != null) {
		        start = start.left == null ? start.right : start.left;
	        }
        }
    }
}
