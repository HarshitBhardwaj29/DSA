class Solution {
    public int helper(int[][] arr,int[][] dp, int i,int j,int m, int n){
        if(i>=m || j>=n) return 0;
        if(arr[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = helper(arr,dp,i+1,j,m,n);
        int down = helper(arr,dp,i,j+1,m,n);
        dp[i][j]=right+down;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1)return 0;
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                if(obstacleGrid[i][j]==1) continue; 
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}