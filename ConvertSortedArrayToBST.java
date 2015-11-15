/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        
        if (len == 0) {
            return null;
        }
        
        int halfLen = (len-1)/2;
        TreeNode result = new TreeNode(nums[halfLen]);
        result.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, halfLen));
        result.right = sortedArrayToBST(Arrays.copyOfRange(nums, halfLen+1, len));
        return result;
    }
}
