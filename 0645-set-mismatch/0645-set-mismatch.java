class Solution {
    public int[] findErrorNums(int[] nums) {
        // a+b-a-a
        int n = nums.length;
        Set s = new HashSet(n);
        int sum = 0;
        int a = 0;
        
        for(int i : nums) {
            sum+=i;
            if (s.contains(i)) {
                a = i;
            } else {
                s.add(i);
            }
        }
        
        return new int[]{a, (n * (n+1) / 2) - sum + a};
    }
}