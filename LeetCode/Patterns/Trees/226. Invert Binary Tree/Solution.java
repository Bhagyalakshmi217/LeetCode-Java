/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        // swap the left nd right child nodes
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        // invert left subtree
        invertTree(root.left);

        // invert right subtree
        invertTree(root.right);

        // return answer
        return root;

        
    }
}