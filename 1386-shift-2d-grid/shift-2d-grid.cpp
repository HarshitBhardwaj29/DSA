class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {

        int n = grid.size();
        int m = grid[0].size();
        vector<int> arr;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr.push_back(grid[i][j]);
            }
        }
        int total = n * m;
        k %= total;
        vector<int> shifted(total);
        for (int i = 0; i < total; i++) {
            shifted[(i + k) % total] = arr[i];
        }
        vector<vector<int>> ans(n, vector<int>(m));

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = shifted[idx++];
            }
        }
        return ans;
    }
};