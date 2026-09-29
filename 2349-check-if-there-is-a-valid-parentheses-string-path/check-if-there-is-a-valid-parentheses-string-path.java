class Solution {
    static class State {
        int i, j, k;
        State(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if ((n + m - 1) % 2 != 0) {
            return false;
        }
        if (grid[0][0] == ')') {
            return false;
        }
        boolean[][][] visited = new boolean[n][m][n + m + 1];
        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {

            State curr = q.poll();

            int i = curr.i;
            int j = curr.j;
            int k = curr.k;

            if (grid[i][j] == '(') {
                k++;
            } else {
                k--;
            }

            if (k < 0) {
                continue;
            }

            if (i == n - 1 && j == m - 1) {
                if (k == 0) {
                    return true;
                }
                continue;
            }
            if (i + 1 < n && !visited[i + 1][j][k]) {
                visited[i + 1][j][k] = true;
                q.offer(new State(i + 1, j, k));
            }
            if (j + 1 < m && !visited[i][j + 1][k]) {
                visited[i][j + 1][k] = true;
                q.offer(new State(i, j + 1, k));
            }
        }

        return false;
    }
}