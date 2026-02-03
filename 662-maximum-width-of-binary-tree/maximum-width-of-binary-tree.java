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
class Pair{
    TreeNode node;
    int w;
    Pair(TreeNode node , int w){
        this.node = node;
        this.w = w;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max=Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                int hz=p.w;
                if (i == 0) first = hz;
                if (i == size - 1) last = hz;
                if(p.node.left!=null){
                    q.add(new Pair(p.node.left,2*hz+1));
                }
                if(p.node.right!=null){
                    q.add(new Pair(p.node.right,2*hz+2));
                }
            }

            max = Math.max(max,last-first+1);
        }
        return max;
    }
}