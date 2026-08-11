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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;
        if(root == null) return null;

        if(root.val > p.val && root.val > q.val)
          lca  = lowestCommonAncestor(root.left, p, q);
        if(root.val < p.val && root.val < q.val)
          lca = lowestCommonAncestor(root.right, p, q);
        
        if(root.val >= p.val && root.val <= q.val){
            lca = root;
        }

        return lca != null ? lca : root;
    }
}
