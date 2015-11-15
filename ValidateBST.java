/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    public boolean isValidBST(TreeNode root, double min, double max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return (isValidBST(root.left, min, Math.min(max, root.val)) && isValidBST(root.right, Math.max(min, root.val), max));
    }
}
