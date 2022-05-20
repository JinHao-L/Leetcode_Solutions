class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (j > 0) {
                    dp[j] += dp[j - 1];
                }
                dp[j] *= (1 - obstacleGrid[i][j]);
            }
        }
        return dp[n - 1];
    }
}