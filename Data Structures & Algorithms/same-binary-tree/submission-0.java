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
        
        insertElement(p);
        // System.out.println("Queue After Insertion "+queue);
        
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
            // System.out.println("Queue Value "+queue.peek());
            // System.out.println(root);
            return queue.poll() == null ? true : false;
            
            // return true;
        }

        boolean left = checkForSimilarity(root.left);
        boolean right = checkForSimilarity(root.right);
        // System.out.println("Root Value "+root.val);
        // System.out.println("Queue Poll "+ queue.peek());

        return queue.peek() != null && root.val == queue.poll() && left && right;
    }
}