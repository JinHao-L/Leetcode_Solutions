class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                // to the right
                start = mid + 2;
            } else {
                // to the left
                end = mid;
            }
        }
        
        return nums[start];
    }
}