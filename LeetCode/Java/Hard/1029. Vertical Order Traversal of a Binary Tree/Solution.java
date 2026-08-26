class Solution {

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // column -> list of (row, value)
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        // root starts at row 0, column 0
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair current = q.poll();

            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            map.putIfAbsent(col, new ArrayList<>());

            // store row and value
            map.get(col).add(new int[]{row, node.val});

            // left child
            if (node.left != null) {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }

            // right child
            if (node.right != null) {
                q.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        // Process columns from left to right
        for (List<int[]> list : map.values()) {

            // Sort by:
            // 1. row
            // 2. value if same row
            Collections.sort(list, (a, b) -> {

                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }

                return a[1] - b[1];
            });

            List<Integer> column = new ArrayList<>();

            for (int[] pair : list) {
                column.add(pair[1]);
            }

            ans.add(column);
        }

        return ans;
    }
}