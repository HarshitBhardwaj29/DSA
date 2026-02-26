class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {

                boolean pick = false;
                if (j >= nums[i]) {
                    pick = dp[i + 1][j - nums[i]];
                }

                boolean notPick = dp[i + 1][j];

                dp[i][j] = pick || notPick;
            }
        }
        return dp[0][target];
    }
}