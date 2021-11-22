class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        int[] sum = new int[n + 1];
        sum[0] = 0;

        int r = n - k;
        int min = -1;
        for(int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + cardPoints[i];
            if (i - r + 1 >= 0) {
                min = min == -1 ? sum[i + 1] - sum[i - r + 1] : Math.min(sum[i + 1] - sum[i - r + 1], min);
            }
        }
        
        return sum[n] - min;
    }
}