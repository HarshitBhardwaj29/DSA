class Pair {
    int x;
    int y;
    int step;
    Pair(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {

        Queue<Pair> q = new LinkedList<>();

        int n = isWater.length;
        int m = isWater[0].length;
        int[][] dist = new int[n][m];
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.x;
            int j = p.y;
            int step = p.step;
            dist[i][j] = step;
            for (int k = 0; k < 4; k++) {
                int dxi = i + dx[k];
                int dyj = j + dy[k];
                if (dxi >= 0 && dyj >= 0 &&
                    dxi < n && dyj < m &&
                    vis[dxi][dyj] == 0) {
                    vis[dxi][dyj] = 1;
                    q.add(new Pair(dxi, dyj, step + 1));
                }
            }
        }
        return dist;
    }
}