class Solution {
    int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;

        height(root);
        
        return maxDiameter;
    }

    public int height(TreeNode node){
        int leftHeight = 0;
        int rightHeight = 0;

        if(node == null) return 0;

        leftHeight = height(node.left);
        rightHeight = height(node.right);
       
        if (leftHeight + rightHeight > maxDiameter) {
            maxDiameter = leftHeight + rightHeight;
        }

        return (leftHeight >= rightHeight ? leftHeight : rightHeight) + 1;

    }
}