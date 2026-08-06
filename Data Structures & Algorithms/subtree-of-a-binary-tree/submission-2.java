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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean result = false;
        if(root == null && subRoot == null) return true;
        if(root == null) return false;

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        
        if(root.val == subRoot.val) result = isSameTree(root, subRoot);
        
        return result || left || right;
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root, subRoot});
        
        while(!stack.isEmpty()){
            TreeNode[] node = stack.pop();
            TreeNode p = node[0];
            TreeNode q = node[1];
            if(p == null && q == null) continue;
            if(p == null || q == null || p.val != q.val) return false;
            stack.push(new TreeNode[] {p.left, q.left});
            stack.push(new TreeNode[] {p.right, q.right});
        }
        return true;
    }
}