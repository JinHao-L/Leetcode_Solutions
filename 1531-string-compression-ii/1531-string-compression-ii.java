class Solution {
    private int[][] dp;
    private int L;
    private char[] chars;
    
    public int getLengthOfOptimalCompression(String s, int k) {
        this.L = s.length();
        this.chars = s.toCharArray();
        this.dp = new int[L + 1][k + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return run(0, k);
    }
    
    public int run(int loc, int remainingDeletion) {
        if (remainingDeletion < 0) return L;
        if (loc + remainingDeletion >= L) return 0;
        
        int best = dp[loc][remainingDeletion];
        if (best != -1) return best;
        
        // delete pos i
        best = run(loc + 1, remainingDeletion - 1);
        
        // keep pos i and find the best outcome if I do so
        int count = 0, lenToAdd = 0, lenToDelete = 0;
        for (int i = loc; i < L && lenToDelete <= remainingDeletion; i++) {
            if (chars[loc] == chars[i]) {
                count++;
                if (count <= 2 || count == 10 || count == 100) {
                    lenToAdd++;
                }
            } else {
                lenToDelete++;
            }
            best = Math.min(best, lenToAdd + run(i + 1, remainingDeletion - lenToDelete));
        }
        
        dp[loc][remainingDeletion] = best;
        return best;
    }
}