class Solution {
    int preIndex=0;
    HashMap<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,inorder.length-1);
        
    }
    private TreeNode build(int[] preorder,int[] inorder,int left,int right){
        if(left>right){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preIndex++]);
            int index=map.get(root.val);
            root.left=build(preorder,inorder,left,index-1);
            root.right=build(preorder,inorder,index+1,right);
            return root;

        }
    }
