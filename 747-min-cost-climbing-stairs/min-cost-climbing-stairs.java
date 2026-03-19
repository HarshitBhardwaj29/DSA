class Solution {
    public int helper(int[] cost,int i,int[] dp){
        if(i>=cost.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int left = helper(cost,i+1,dp);
        int right = helper(cost,i+2,dp);
        return dp[i]= cost[i]+Math.min(left,right);
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        helper(cost,0,dp);
        helper(cost,1,dp);
        return Math.min(dp[0],dp[1]);
    }
}