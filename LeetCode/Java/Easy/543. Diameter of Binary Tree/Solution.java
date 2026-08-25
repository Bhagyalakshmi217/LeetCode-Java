class Solution {
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return diameter;
    }
    private int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=diameter(root.left);
        int right=diameter(root.right);
        diameter=Math.max(diameter,left+right);
        return 1+Math.max(left,right);
    }
        
    
}