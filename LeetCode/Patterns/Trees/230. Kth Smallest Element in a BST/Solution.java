// class Solution {

//     int count = 0;

//     public int kthSmallest(TreeNode root, int k) {

//         if (root == null) {
//             return -1;
//         }

//         int left = kthSmallest(root.left, k);

//         if (left != -1) {
//             return left;
//         }

//         count++;

//         if (count == k) {
//             return root.val;
//         }

//         return kthSmallest(root.right, k);
//     }
// }

class Solution {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            k--;

            if (k == 0) {
                return curr.val;
            }

            curr = curr.right;
        }

        return -1;
    }
}