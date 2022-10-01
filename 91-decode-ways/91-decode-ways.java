class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            
            if (curr != 0) {
                dp[i] += i - 1 >= 0 ? dp[i - 1] : 1;
            }
            
            if (i >= 1) {
                int prev = s.charAt(i - 1) - '0';
                
                if (prev != 0 && (prev * 10 + curr) <= 26) {
                    dp[i] += i - 2 >= 0 ? dp[i - 2] : 1;
                }
            }
        }
        
        
        return dp[s.length() - 1];
    }
}