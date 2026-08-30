class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        int ans = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // First index of this level
            int min = q.peek().num;

            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                TreeNode node = p.node;

                // Make index start from 0
                int curr_id = p.num - min;

                if (i == 0) {
                    first = curr_id;
                }

                if (i == size - 1) {
                    last = curr_id;
                }

                if (node.left != null) {
                    q.offer(new Pair(
                        node.left,
                        curr_id * 2 + 1
                    ));
                }

                if (node.right != null) {
                    q.offer(new Pair(
                        node.right,
                        curr_id * 2 + 2
                    ));
                }
            }

            ans = Math.max(ans, (int)(last - first + 1));
        }

        return ans;
    }
}