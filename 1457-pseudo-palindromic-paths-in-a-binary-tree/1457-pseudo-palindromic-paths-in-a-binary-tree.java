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
        boolean[] odd = new boolean[9];
        return traverse(root, odd);
    }
    
    public int traverse(TreeNode root, boolean[] odd) {
        if (root == null) {
            return 0;
        }

        odd[root.val - 1] = !odd[root.val - 1];
        if (root.left == null && root.right == null) {
            int numOdds = 0;
            for(int i = 0; i < odd.length; i++) {
                if (odd[i]) numOdds++;
            }
            odd[root.val - 1] = !odd[root.val - 1];
            return numOdds <= 1 ? 1 : 0;
        }

        int left = traverse(root.left, odd);
        int right = traverse(root.right, odd);
        odd[root.val - 1] = !odd[root.val - 1];
        
        return left + right;
    }
}