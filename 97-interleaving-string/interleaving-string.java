class Solution {

    public boolean helper(String s1, String s2, String s3, int i, int j, int k,Boolean[][][] dp) {
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }
        boolean ans = false;
        if(dp[i][j][k]!=null)return dp[i][j][k];
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = helper(s1, s2, s3, i + 1, j, k + 1,dp);
        }
        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = helper(s1, s2, s3, i, j + 1, k + 1,dp);
        }
        dp[i][j][k] = ans;
        return dp[i][j][k];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][][] dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return helper(s1, s2, s3, 0, 0, 0,dp);
    }
}
