import java.util.*;

class Pair {
    int x, y, dis;
    Pair(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.add(new Pair(0, 0, 0));
        dist[0][0] = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int x = p.x, y = p.y, d = p.dis;
            if (x == n - 1 && y == m - 1) return d;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int newEffort = Math.max(d, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (newEffort < dist[nx][ny]) {
                        dist[nx][ny] = newEffort;
                        pq.add(new Pair(nx, ny, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}