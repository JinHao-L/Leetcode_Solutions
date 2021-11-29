class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int rob = nums[0];
        int noRob = 0;
        for(int i = 1; i < n; i++) {
            int tempRob = rob;
            rob = Math.max(rob, noRob + nums[i]);
            noRob = tempRob;
        }
        
        return Math.max(rob, noRob);
    }
}