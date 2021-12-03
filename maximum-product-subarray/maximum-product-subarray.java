class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = nums[0];
        
        for(int d = 0; d < n; d++) {
            for(int s = 0; s + d < n; s++) {
                if (d == 0) {
                    dp[s] = nums[s];
                } else {
                    dp[s] = dp[s] * nums[s + d];
                }
                
                res = Math.max(res, dp[s]);
            }
        }
        
        return res;
    }
}