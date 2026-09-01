// class Solution {
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
        
//     }
// }

class Solution {
    int postIndex;
    HashMap<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(postorder,inorder,0,inorder.length-1);
        
    }
    private TreeNode build(int[] postorder,int[] inorder,int left,int right){
        if(left>right){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postIndex--]);
            int index=map.get(root.val);
            root.right=build(postorder,inorder,index+1,right);
            root.left=build(postorder,inorder,left,index-1);
            return root;

        }
    }