class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int d = 0; d < nums.length; d++) {
            for(int i = 0; i + d < nums.length; i++) {
                int max = 0;
                int j = i + d;
                for(int k = i; k <= i + d; k++) {
                    int leftMax = (i <= k - 1 ? dp[i][k - 1] : 0);
                    int left = (i - 1 >= 0 ? nums[i - 1] : 1);
                    int right = (j + 1 < n ? nums[j + 1] : 1);
                    int rightMax = (k + 1 <= j ? dp[k + 1][j] : 0);
                    
                    max = Math.max(max, leftMax + left * nums[k] * right + rightMax);
                }
                dp[i][j] = max;
            }
        }
        
        return dp[0][n - 1];
    }
}