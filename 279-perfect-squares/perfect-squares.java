class Solution {
    public int helper(int n,int[] dp) {
        if (n == 0) return 0;
        int min = Integer.MAX_VALUE;
        if(dp[n]!=-1)return dp[n];
        for (int i = 1; i * i <= n; i++) {
            int ans = 1 + helper(n - (i * i),dp);
            min = Math.min(min, ans);
        }
        dp[n] = min;
        return dp[n];
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
}