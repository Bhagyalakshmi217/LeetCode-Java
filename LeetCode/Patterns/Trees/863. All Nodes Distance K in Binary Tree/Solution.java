class Solution {

    public List<Integer> distanceK(
            TreeNode root,
            TreeNode target,
            int k) {

        List<Integer> ans = new ArrayList<>();

        // node -> parent
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        // Step 1: Store parents
        markParents(root, parent);

        // Step 2: BFS from target
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // We reached distance k
            if (distance == k) {

                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }

                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    q.offer(node.left);
                }

                // Right
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.offer(node.right);
                }

                // Parent
                if (parent.containsKey(node) &&
                    !visited.contains(parent.get(node))) {

                    visited.add(parent.get(node));
                    q.offer(parent.get(node));
                }
            }

            distance++;
        }

        return ans;
    }

    private void markParents(
            TreeNode root,
            Map<TreeNode, TreeNode> parent) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            parent.put(root.left, root);
            markParents(root.left, parent);
        }

        if (root.right != null) {
            parent.put(root.right, root);
            markParents(root.right, parent);
        }
    }
}