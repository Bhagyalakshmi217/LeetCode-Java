class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        rightView(root,result,0);
        return result;
        
    }
    private void rightView(TreeNode root,List<Integer> result,int currDepth){
        if(root==null){
            return;
        }
        if(currDepth==result.size()){
            result.add(root.val);
        }
            rightView(root.right,result,currDepth+1);
            rightView(root.left,result,currDepth+1);

        
    }
}