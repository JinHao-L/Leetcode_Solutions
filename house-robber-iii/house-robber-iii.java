/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] toRobOrNotToRob = accomplice(root);
        return Math.max(toRobOrNotToRob[0], toRobOrNotToRob[1]);
    }
    
    public int[] accomplice(TreeNode curr) {
        if (curr == null) {
            return new int[]{0, 0};
        }
        
        int[] right = accomplice(curr.right);
        int[] left = accomplice(curr.left);
        
        int rob = curr.val + right[1] + left[1];
        int skip = Math.max(right[0], right[1]) + Math.max(left[0], left[1]);
        return new int[]{rob, skip};
    }
}