class Solution {
    public int singleNonDuplicate(int[] nums) {
        int single = 0;
        for(int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }
}