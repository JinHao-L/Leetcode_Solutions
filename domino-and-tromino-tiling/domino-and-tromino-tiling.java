class Solution {
    long MOD = 1000000007;
    long[][] dp;
    
    public int numTilings(int n) {
        dp = new long[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        
        for(int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][1];
            
            if (i >= 2) {
                dp[i][0] += dp[i - 2][0] + dp[i - 1][1] * 2;
                dp[i][1] += dp[i - 2][0];
            }
            
            dp[i][0] %= MOD;
            dp[i][1] %= MOD;
        }
        
        return (int) dp[n][0];
    }
}
