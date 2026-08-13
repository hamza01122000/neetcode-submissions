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

    public boolean isValidBST(TreeNode root) {
        return inOrderTraversal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean inOrderTraversal(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        boolean left = inOrderTraversal(root.left, min, root.val);
        // list.add(root.val);
        boolean right = inOrderTraversal(root.right, root.val, max);

        return left && right;
    }
}