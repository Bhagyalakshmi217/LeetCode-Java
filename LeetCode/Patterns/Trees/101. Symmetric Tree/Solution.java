class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null || checkSyemmetry(root.left,root.right);
        
    }
    private boolean checkSyemmetry(TreeNode left,TreeNode right){
        if(left==null || right==null){
            return left==right;
        }
        if(left.val!=right.val){
            return false;
        }
        return checkSyemmetry(left.left,right.right) 
                &&
                checkSyemmetry(left.right,right.left);

    }
}