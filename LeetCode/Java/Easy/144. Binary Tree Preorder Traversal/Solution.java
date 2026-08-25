class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
        
    }
    private void preorder(TreeNode root){
        if(root==null){
            return;
        }
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}