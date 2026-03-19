class Solution {
    public int helper(int[] nums,int i,int prev,int[][] dp){
        if(i==nums.length)return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int take = 0;
        if(prev==-1 || nums[i]>nums[prev]){
            take = 1+helper(nums,i+1,i,dp);
        }
        int nottake = helper(nums,i+1,prev,dp);
        dp[i][prev+1] = Math.max(take,nottake);
        return dp[i][prev+1];
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(nums,0,-1,dp);
    }
}