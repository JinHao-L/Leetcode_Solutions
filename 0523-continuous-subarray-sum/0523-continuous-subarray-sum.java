class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int prev = 0;
        
        for(int i : nums) {
            sum += i;
            int remainder = sum % k;
            if (set.contains(remainder)) return true;
            set.add(prev);
            prev = remainder;
        }
        
        return false;
    }
}