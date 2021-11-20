class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for(int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                int denom = coins[j];
                if (i - denom >= 0 && dp[i - denom] != -1) {
                    if (dp[i] == -1 || dp[i - denom] + 1 < dp[i]) {
                        dp[i] = dp[i - denom] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}