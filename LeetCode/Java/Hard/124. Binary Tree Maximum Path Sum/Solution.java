class Solution {
    int maximum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        pathSum(root);
        return maximum;

        
    }
    private int pathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum=Math.max(0,pathSum(root.left));
        int rightSum=Math.max(0,pathSum(root.right));
        maximum=Math.max(maximum,leftSum+rightSum+root.val);
        return Math.max(leftSum,rightSum)+root.val;
    }
}