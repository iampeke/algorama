/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSTR(p, q);
    }
    
    public boolean isSTR(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root2 == null) {
            return false;
        } else {
            if (root1.val == root2.val) {
                return (isSTR(root1.left, root2.left) && isSTR(root1.right, root2.right));
            } else {
                return false;
            }
        }
    }
}
