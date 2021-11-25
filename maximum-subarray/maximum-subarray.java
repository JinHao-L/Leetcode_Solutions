class Solution {
    public int maxSubArray(int[] nums) {
        int prevMin = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            sum += i;
            max = Math.max(sum - prevMin, max);
            prevMin = Math.min(sum, prevMin);
        }
        return max;
    }
}