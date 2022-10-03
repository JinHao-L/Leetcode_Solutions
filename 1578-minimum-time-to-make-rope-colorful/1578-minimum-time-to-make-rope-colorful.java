class Solution {
    public int minCost(String colors, int[] neededTime) {
        char prev = ' ';
        int max = 0, sum = 0, cost = 0;

        for(int i = 0; i < neededTime.length; i++) {
            char curr = colors.charAt(i);
            if (prev == curr) {
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
            } else {
                cost += sum - max;
                sum = neededTime[i];
                max = neededTime[i];
                prev = curr;
            }
        }
        cost += sum - max;
        
        return cost;
    }
}