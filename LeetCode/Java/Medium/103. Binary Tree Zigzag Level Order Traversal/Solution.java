// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> ans=new ArrayList();
//         Queue<TreeNode> q=new LinkedList();
//         if(root==null){
//             return ans;
//         }
//         q.offer(root);
//         while(!q.isEmpty()){
//             int size=q.size();
//             List<Integer> level=new ArrayList();
//             for(int i=0;i<size;i++){
//                 TreeNode curr=q.poll();
//                 level.add(curr.val);
//                 if(curr.left!=null){
//                     q.offer(curr.left);
//                 }
//                 if(curr.right!=null){
//                     q.offer(curr.right);
//                 }
//             }
//                 ans.add(level);
            
//         }
//         return ans;
        
//     }
// }


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                level.add(curr.val);

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }

            ans.add(level);

            leftToRight = !leftToRight;
        }

        return ans;
    }
}