class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int best = 0;
        int sum = 0;
        
        for(int i = n - 1; i >= 0; i--) {
            int newArr = satisfaction[i];
            int contArr = best + sum + satisfaction[i];
            if (newArr > contArr && newArr > best) {
                best = newArr;
                sum = newArr;
            } else if (contArr > best) {
                best = contArr;
                sum = sum + satisfaction[i];
            }
        }
        
        return best;
    }
}