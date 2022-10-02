class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > k * n) return 0;
        long mod = 1_000_000_007;

        long[][] dp = new long[n + 1][target + 1];
        dp[0][0] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= target; j++) {
                for(int m = 1; m <= k && j - m >= 0; m++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - m]) % mod;
                }
            }
        }
        
        return (int) dp[n][target];
    }
}