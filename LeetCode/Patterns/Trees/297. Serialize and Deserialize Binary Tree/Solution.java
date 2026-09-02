public class Codec {

    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Deserialize
    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");

        Queue<String> q = new LinkedList<>();

        for (String s : arr) {
            q.offer(s);
        }

        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q) {

        String curr = q.poll();

        if (curr.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(curr));

        root.left = buildTree(q);

        root.right = buildTree(q);

        return root;
    }
}
