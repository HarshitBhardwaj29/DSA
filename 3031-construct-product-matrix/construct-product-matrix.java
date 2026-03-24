class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;
        int mod = 12345;
        int[] pref = new int[size];
        int[] suff = new int[size];
        int[] arr = new int[size];
        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                arr[idx++] = val;
            }
        }
        pref[0] = 1;
        for (int i = 1; i < size; i++) {
            pref[i] = (int)((pref[i - 1] * 1L * arr[i - 1]) % mod);
        }
        suff[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suff[i] = (int)((suff[i + 1] * 1L * arr[i + 1]) % mod);
        }
        int[][] result = new int[n][m];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = (int)((pref[idx] * 1L * suff[idx]) % mod);
                idx++;
            }
        }
        return result;
    }
}