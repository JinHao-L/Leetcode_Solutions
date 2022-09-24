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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        int newSum = targetSum - root.val;

        if (newSum == 0 && root.left == null && root.right == null) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList(Arrays.asList(root.val)));
            return res;
        }
        
        List<List<Integer>> left = pathSum(root.left, newSum);
        List<List<Integer>> right = pathSum(root.right, newSum);

        left.addAll(right);
        for(List<Integer> ls : left) {
            ls.add(0, root.val);
        }

        return left;
    }
}