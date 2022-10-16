class Solution {
    int L;
    int[][] dp;
    // min difficulty of schedule from 0-L in d days
    int[] jobDifficulty;

    public int minDifficulty(int[] jobDifficulty, int d) {
        this.L = jobDifficulty.length;
        this.dp = new int[d + 1][L];
        this.jobDifficulty = jobDifficulty;
        
        Arrays.fill(dp[0], -1);
        for(int i = 1; i <= d; i++) {
            Arrays.fill(dp[i], -2);
        }
        int ans = dp(L - 1, d);
        
        dp[0][0] = 0;
        
        return ans;
    }
    
    public int dp(int pos, int days) {
        if (days > pos + 1) return -1;
        if (pos < 0) return 0;
        int ans = dp[days][pos];
        if (ans != -2) return ans;

        ans = -1;
        int max = jobDifficulty[pos];
        for(int i = pos; i >= 0; i--) {
            max = Math.max(max, jobDifficulty[i]);
            int prevDay = dp(i - 1, days - 1);
            if (prevDay != -1) {
                if (ans == -1) {
                    ans = prevDay + max;
                } else {
                    ans = Math.min(ans, prevDay + max);
                }
            }
            if (days == 3) {
                System.out.println(i + ": " + prevDay + ", " + max);
            }
        }
        dp[days][pos] = ans;
        return ans;
    }
}