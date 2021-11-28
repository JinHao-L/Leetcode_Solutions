class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
    
        return longestCommonSubsequence(nums, sorted);
    }
    
    public int longestCommonSubsequence(int[] arr1, int[] arr2) {
        int n = arr1.length;
        
        int[][] dp = new int[n][n];

        int prev = 10001;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (arr1[i] == arr2[j] && arr1[i] != prev) {
                    prev = arr1[i];
                    dp[i][j] = getVal(dp, i - 1, j - 1) + 1;
                } else {
                    dp[i][j] = Math.max(getVal(dp, i - 1, j), getVal(dp, i, j - 1));
                }
            }
        }
        
        return dp[n - 1][n - 1];
    }
    
    public int getVal(int[][] dp, int i, int j) {
        if (i < 0) return 0;
        if (j < 0) return 0;
        return dp[i][j];
    }
}