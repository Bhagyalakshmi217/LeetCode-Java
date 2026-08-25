class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightDfs(root)!=-1;
        
    }
    int heightDfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=heightDfs(root.left);
        int right=heightDfs(root.right);
        if(Math.abs(left-right)>1){
            return -1;
        }
        return 1+Math.max(left,right);
    } 
}