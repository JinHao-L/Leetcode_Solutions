class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        
        // rob-0, norob-0, rob-1, norob-1
        int[] paths = new int[4];
        
        for(int i = 0; i < n; i++) {
            if (i > 0) {
                int temp = paths[0];
                paths[0] = Math.max(paths[0], paths[1] + nums[i]);
                paths[1] = temp;
            }
            
            if (i < n - 1) {
                int temp = paths[2];
                paths[2] = Math.max(paths[2], paths[3] + nums[i]);
                paths[3] = temp;
            }
        }
        
        int max = 0;
        for(int val : paths) {
            max = Math.max(max, val);
        }
        return max;
    }
}