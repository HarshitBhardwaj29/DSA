class Solution {
    static int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        boolean[] vis = new boolean[n];
        pq.add(new int[]{0,0});
        int res = 0;
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int node = arr[0];
            int wt = arr[1];
            if(vis[node])continue;
            vis[node]=true;
            res+=wt;
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    int dist = manhattanDistance(points[i],points[node]);
                    pq.add(new int[]{i,dist});
                }
            }
        }
        return res;
    }
}