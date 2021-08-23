class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[]{1, numbers.length};
        
        while(res[0] < res[1]) {
            int sum = numbers[res[0] - 1] + numbers[res[1] - 1];
            if (sum == target) {
                return res;
            } else if (sum < target) {
                res[0]++;
            } else {
                res[1]--;
            }
        }
        
        return null;
    }
}