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

    Queue<Integer> queue = new LinkedList<>();

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        insertElement(p);        
        return checkForSimilarity(q) && queue.isEmpty();
    }

    public TreeNode insertElement(TreeNode root){
        if(root == null){
            queue.offer(null);
            return null;
        }

        insertElement(root.left);
        insertElement(root.right);
        queue.offer(root.val);

        return root;
    }

    public boolean checkForSimilarity(TreeNode root){
        if(root == null){

            return queue.poll() == null ? true : false;
            
        }

        boolean left = checkForSimilarity(root.left);
        boolean right = checkForSimilarity(root.right);
        
        return queue.peek() != null && root.val == queue.poll() && left && right;
    }
}