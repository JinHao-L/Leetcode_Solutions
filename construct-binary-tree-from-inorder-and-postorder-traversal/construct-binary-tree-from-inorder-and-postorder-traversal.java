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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTree(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    
    public TreeNode buildTree(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (r1 < l1) {
            return null;
        }
        
        int root = postorder[r2];
        TreeNode rootNode = new TreeNode(root);
        
        int pivot;
        for(pivot = l1; pivot <= r1; pivot++) {
            if (inorder[pivot] == root) {
                break;
            }
        }
        
        int numLeft = pivot - l1;
        rootNode.left = buildTree(inorder, l1, pivot - 1, postorder, l2, l2 + numLeft - 1);
        rootNode.right = buildTree(inorder, pivot + 1, r1, postorder, l2 + numLeft, r2 - 1);
        
        
        return rootNode;
    }
}