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
    private List<Integer> arr ;
    private void dfs(TreeNode root) {
        if(root != null) {
            dfs(root.left) ;
            arr.add(root.val) ;
            dfs(root.right) ;
        }
    }

    private TreeNode construct(int start, int end) {
        if(start > end) {
            return null ;
        }
        int mid = start + (end - start) / 2 ;
        TreeNode root = new TreeNode(arr.get(mid)) ;
        root.left = construct(start, mid - 1) ;
        root.right = construct(mid + 1, end) ;
        return root ;
    }

    public TreeNode balanceBST(TreeNode root) {
        arr = new ArrayList<>() ;
        dfs(root) ;
        return construct(0, arr.size()-1) ;
    }
}