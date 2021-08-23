class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < 0) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        int neg = start - 1;
        int pos = start;
        
        // start == boundary of +ve & -ve
        int[] arr = new int[nums.length];
        for(int i = 0; i < arr.length; i++) {
            if (pos < nums.length && neg >= 0) {
                if (nums[pos] < -nums[neg]) {
                    arr[i] = nums[pos] * nums[pos];
                    pos++;
                } else {
                    arr[i] = nums[neg]*nums[neg];
                    neg--;
                }
            } else if (pos < nums.length) {
                arr[i] = nums[pos] * nums[pos];
                pos++;
            } else {
                arr[i] = nums[neg]*nums[neg];
                neg--;
            }
        }
        
        return arr;
    }
}