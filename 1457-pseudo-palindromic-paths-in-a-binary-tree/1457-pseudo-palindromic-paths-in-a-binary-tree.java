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
    public int pseudoPalindromicPaths (TreeNode root) {
        return traverse(root, 0);
    }
    
    public int traverse(TreeNode node, int path) {
        if (node == null) {
            return 0;
        }

        int result = 0;
        path ^= (1 << node.val);

        if (node.left == null && node.right == null) {
            result = (path & (path - 1)) == 0 ? 1 : 0;
        } else {
            result = traverse(node.left, path) + traverse(node.right, path);
        }

        path ^= (1 << node.val);
        
        return result;
    }
}