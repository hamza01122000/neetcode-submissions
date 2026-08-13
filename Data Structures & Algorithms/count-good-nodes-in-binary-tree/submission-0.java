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

    // ArrayList<Integer> list = new ArrayList<>();

    public int goodNodes(TreeNode root) {
        
        return calculateGoodNodes(root, root.val);
    }

    public int calculateGoodNodes(TreeNode root, int maxSoFar){
        int count = 0;
        if(root == null) return 0;
        maxSoFar = Math.max(maxSoFar, root.val);

        if(root.val >= maxSoFar) count = 1;
        
        int left = calculateGoodNodes(root.left, maxSoFar);
        int right = calculateGoodNodes(root.right, maxSoFar);

        return count + left + right;
    }
}