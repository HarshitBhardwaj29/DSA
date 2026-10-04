class Solution {
    Boolean[][] memo;

    public boolean checkValidString(String s) {
        memo = new Boolean[s.length()][s.length()];
        return dfs(s, 0, 0);
    }

    private boolean dfs(String s, int i, int balance) {
        if (balance < 0) return false;
        if (i == s.length()) return balance == 0;

        if (memo[i][balance] != null) return memo[i][balance];

        char ch = s.charAt(i);
        boolean res;

        if (ch == '(') {
            res = dfs(s, i + 1, balance + 1);
        } else if (ch == ')') {
            res = dfs(s, i + 1, balance - 1);
        } else {
            res = dfs(s, i + 1, balance + 1) ||
                  dfs(s, i + 1, balance - 1) ||
                  dfs(s, i + 1, balance);
        }

        return memo[i][balance] = res;
    }
}
