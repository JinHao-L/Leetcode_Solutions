class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int target = nums.length - 1;
        
        while (target != 0) {
            for(int i = 0; i < target; i++) {
                if (target - i <= nums[i]) {
                    target = i;
                    jumps++;
                    break;
                }
            }
        }
        
        return jumps;
    }
}