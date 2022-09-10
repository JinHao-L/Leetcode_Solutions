class Solution {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        int[][] dp = new int[k + 1][days];
        
        if (days <= k) {
            int profit = 0;
            for(int i = 1; i < days; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            
            return profit;
        }
        
        
        for(int i = 1; i <= k; i++) {
            int possibleProfit = -prices[0];
            for(int j = 1; j < days; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], possibleProfit + prices[j]);
                possibleProfit = Math.max(possibleProfit, dp[i - 1][j - 1] - prices[j]);
            }
            
            dp[i][days - 1] = Math.max(dp[i][days - 1], dp[i - 1][days - 2]);
        }
        
        return dp[k][days - 1];
    }
}