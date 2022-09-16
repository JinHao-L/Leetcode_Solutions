class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[] dp = new int[n];
        
        int res = Integer.MIN_VALUE;
        for(int i = m - 1; i >= 0; i--) {
            int size = n - 1 - i;
            for(int j = 0; j + size < n; j++) {

                int left = dp[j] + nums[j + size] * multipliers[i];
                int right = (j + 1 < n ? dp[j + 1] : dp[j]) + nums[j] * multipliers[i];
                
                dp[j] = Math.max(left, right);
                
                if (i == 0) {
                    res = Math.max(res, dp[j]);
                }
            }
        }
        
        return res;
    }
}
