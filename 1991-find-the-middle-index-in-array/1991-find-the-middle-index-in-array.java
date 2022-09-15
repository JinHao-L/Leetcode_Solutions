class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int value : nums) {
            sum += value;
        }
        
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum * 2 + nums[i] == sum) {
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }
}