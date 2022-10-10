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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        return dfs(root, seen, k);
    }
    
    public boolean dfs(TreeNode root, Set<Integer> seen, int target) {
        if (root == null) return false;
        if (seen.contains(root.val)) return true;
        seen.add(target - root.val);
        return dfs(root.left, seen, target) || dfs(root.right, seen, target);
    }
}