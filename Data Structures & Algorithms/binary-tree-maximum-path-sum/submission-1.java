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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int val = calculateMaxValue(root);
        return Math.max(val, maxSum);
    }

    public int calculateMaxValue(TreeNode root){
        int sum = Integer.MIN_VALUE;
        if(root == null) return 0;

        int left = calculateMaxValue(root.left);
        int right = calculateMaxValue(root.right);

        sum = Math.max(root.val, Math.max(left + root.val, right + root.val));
        int temp = root.val + left + right;
        temp = Math.max(temp, sum);
        maxSum = Math.max(temp, maxSum);

        return sum;
    }
}