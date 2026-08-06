/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        return Math.abs(leftheight - rightheight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node) {
        int left = 0;
        int right = 0;
        if (node == null) return 0;

        left = height(node.left) + 1;
        right = height(node.right) + 1;

        return left >= right ? left : right;
    }
}