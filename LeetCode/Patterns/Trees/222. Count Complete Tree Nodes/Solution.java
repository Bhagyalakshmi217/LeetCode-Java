class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=getHeightLeft(root);
        int right=getHeightRight(root);
        if(left==right){
            return (1 << left) - 1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
        

        
    }
    private int getHeightLeft(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;

    }
    private int getHeightRight(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;

    }

}