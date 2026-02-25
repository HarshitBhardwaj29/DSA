import java.util.*;

class Pair {
    int x, y, dist;
    Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Pair(0,0,0));
        dist[0][0] = 0;

        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            if(p.x == n-1 && p.y == m-1)return p.dist;
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int effort = Math.max(p.dist,Math.abs(heights[p.x][p.y] - heights[nx][ny]));
                    if(effort < dist[nx][ny]) {
                        dist[nx][ny] = effort;
                        pq.add(new Pair(nx, ny, effort));
                    }
                }
            }
        }

        return 0;
    }
}