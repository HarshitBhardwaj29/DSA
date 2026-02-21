class Solution {
    public int helper(List<List<Integer>> triangle, int i, int j,int[][] dp) {
        if(i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int down = triangle.get(i).get(j) + helper(triangle, i+1, j,dp);
        int diagonal = triangle.get(i).get(j) + helper(triangle, i+1, j+1,dp);
        dp[i][j] = Math.min(down, diagonal);
        return  dp[i][j];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = triangle.get(i).get(j)+ Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
    return dp[0][0];
    }
}