public class Solution {
    public static final long MOD = 1_000_000_007;

    public long fibo(int n, long[] dp) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (dp[n] != -1) return dp[n];

        dp[n] = (fibo(n - 1, dp) + fibo(n - 2, dp)) % MOD;
        return dp[n];
    }

    public int countHousePlacements(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        long k = fibo(n, dp);
        long ans = (k * k) % MOD;
        return (int) ans;
    }
}