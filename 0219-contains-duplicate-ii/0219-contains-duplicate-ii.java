class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int start = 0;
        int end = 0;
        
        while (end < nums.length) {
            if (set.contains(nums[end])) {
                return true;
            }
            set.add(nums[end]);
            end++;
            if (start + k < end) set.remove(nums[start++]);
        }
        
        return false;
    }
}