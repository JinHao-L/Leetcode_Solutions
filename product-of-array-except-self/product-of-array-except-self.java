class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int val = nums[i];
            res[i] = nums[i - 1] * res[i - 1];
        }
        
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--) {
            int val = nums[i];
            res[i] = res[i] * suffix;
            suffix = suffix * nums[i];
        }
        
        return res;
    }
}