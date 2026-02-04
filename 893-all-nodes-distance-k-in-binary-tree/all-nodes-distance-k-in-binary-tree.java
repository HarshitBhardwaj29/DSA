/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void parent(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                q.add(node.left);
                parent_track.put(node.left,node);
            }
            if(node.right!=null){
                q.add(node.right);
                parent_track.put(node.right,node);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        parent(root, parent_track);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);

        int curr_level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (curr_level == k) break;

            curr_level++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && !visited.containsKey(curr.left)) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }

                if (curr.right != null && !visited.containsKey(curr.right)) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_track.get(curr) != null && !visited.containsKey(parent_track.get(curr))) {
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }
}
