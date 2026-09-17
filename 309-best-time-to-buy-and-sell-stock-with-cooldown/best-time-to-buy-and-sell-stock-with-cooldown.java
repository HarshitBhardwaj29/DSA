class Solution {
    public int helper(int[] prices, int i, int buy, int[][] dp) {
        if (i >= prices.length) return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        int profit;

        if (buy == 1) {
            profit = Math.max(
                -prices[i] + helper(prices, i + 1, 0, dp),
                helper(prices, i + 1, 1, dp)
            );
        } 
        else {
            profit = Math.max(
                prices[i] + helper(prices, i + 2, 1, dp),
                helper(prices, i + 1, 0, dp)
            );
        }

        return dp[i][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return helper(prices, 0, 1, dp);
    }
}