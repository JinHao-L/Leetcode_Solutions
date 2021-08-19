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
    public int goodNodes(TreeNode root) {
        return dfs(root, -10001);
    }
    
    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        
        int good = 0;
        if (root.val >= max) {
            good++;
            max = root.val;
        }
        return good + dfs(root.left, max) + dfs(root.right, max);
    }
}