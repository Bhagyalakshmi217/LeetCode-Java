class Solution {
    public void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left != null) {

                // Find the rightmost node of the left subtree
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Connect the original right subtree
                prev.right = curr.right;

                // Move the left subtree to the right
                curr.right = curr.left;

                // Remove the left child
                curr.left = null;
            }

            // Move to the next node
            curr = curr.right;
        }
    }
}