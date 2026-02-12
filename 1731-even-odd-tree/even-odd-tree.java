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

    public boolean isIncreasing(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    public boolean isDecreasing(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= list.get(i - 1)) return false;
        }
        return true;
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int c = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            if (c % 2 == 0) {
                for (int x : list) {
                    if (x % 2 == 0) return false;
                }
                if (!isIncreasing(list)) return false;
            }

            else {
                for (int x : list) {
                    if (x % 2 != 0) return false;
                }
                if (!isDecreasing(list)) return false;
            }
            c++;
        }

        return true;
    }
}
