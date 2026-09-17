class Solution {
    public int helper(int n,int[] dp){
        if(n==0)return 1;
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int onestep = helper(n-1,dp);
        int secondstep = helper(n-2,dp);
        dp[n] = onestep+secondstep;
        return dp[n];

    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
}