// class Solution {
//     List<Integer> result=new ArrayList<>();
//     public List<Integer> inorderTraversal(TreeNode root) {
        
//         inorder(root);
//         return result;
//     }
//     private void inorder(TreeNode root){
//         if(root==null){
//             return;
//         }
        
//         inorder(root.left);
//         result.add(root.val);
//         inorder(root.right);
        
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            // Case 1: No left subtree
            if (curr.left == null) {

                ans.add(curr.val);
                curr = curr.right;
            }

            // Case 2: Left subtree exists
            else {

                // Find inorder predecessor
                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // First time visiting curr
                if (prev.right == null) {

                    // Create thread
                    prev.right = curr;

                    curr = curr.left;
                }

                // Thread already exists
                else {

                    // Remove thread
                    prev.right = null;

                    ans.add(curr.val);

                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}