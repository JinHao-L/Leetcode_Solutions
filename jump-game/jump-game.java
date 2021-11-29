class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i <= max && i < nums.length; i++) {
            max = Math.max(i + nums[i], max);
        }
        
        return max >= nums.length - 1;
    }
}