class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (!map.containsKey(remainder)) 
                map.put(sum % k, i);
            else if (map.get(remainder) < i - 1)
                return true;
        }
        
        return false;
    }
}