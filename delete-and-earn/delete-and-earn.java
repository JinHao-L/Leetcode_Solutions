class Solution {
    public int deleteAndEarn(int[] nums) {
        int MAX = 10001;
        int[] freq = new int[MAX];
        for(int i : nums) {
            freq[i]++;
        }
        
        int prevprev = 0;
        int prev = 0;
        
        for(int i = 0; i < MAX; i++) {
            int temp = prev;
            prev = Math.max(prevprev + i * freq[i], prev);
            prevprev = temp;
        }
        
        return Math.max(prev, prevprev);
    }
}