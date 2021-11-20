class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = getVal(dp, i - 1, j - 1) + 1;
                } else {
                    dp[i][j] = Math.max(getVal(dp, i - 1, j), getVal(dp, i, j - 1));
                }
            }
        }
        return dp[n - 1][m - 1];
    }
    
    public int getVal(int[][] dp, int i, int j) {
        if (i < 0) return 0;
        if (j < 0) return 0;
        return dp[i][j];
    }
}