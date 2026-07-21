class Solution {
    public int helper(int[] coins,int amount,int i,int[][] dp){
        if (i == 0) {
            if (amount% coins[0] == 0) return amount / coins[0];
            else return (int)1e9; 
        }
        if(dp[i][amount]!=-1)return dp[i][amount];
        int notpick = helper(coins,amount,i-1,dp);
        int pick=(int)1e9;
        if(coins[i]<=amount){
            pick = 1+helper(coins,amount-coins[i],i,dp);
        }
        dp[i][amount] = Math.min(pick,notpick);
        return dp[i][amount];
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp){
            java.util.Arrays.fill(row, -1);
        }
        int ans = helper(coins, amount, n - 1, dp);
        if (ans >= (int)1e9) return -1;
        return ans;
    }
}