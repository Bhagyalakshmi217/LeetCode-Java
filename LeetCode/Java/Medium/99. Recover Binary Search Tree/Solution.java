class Solution {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {

        inorder(root);

        // Swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // LEFT
        inorder(root.left);

        // ROOT
        if (prev != null && prev.val > root.val) {

            if (first == null) {
                first = prev;
            }

            second = root;
        }

        prev = root;

        // RIGHT
        inorder(root.right);
    }
}