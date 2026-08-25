class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return result;
    }
    private void postorder(TreeNode root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        result.add(root.val);
    }
}