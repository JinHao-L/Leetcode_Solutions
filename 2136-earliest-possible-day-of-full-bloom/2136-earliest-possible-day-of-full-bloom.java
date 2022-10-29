class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[] sortedIndices = IntStream
                        .range(0, plantTime.length)
                        .boxed()
                        .sorted((i, j) -> growTime[j] - growTime[i])
                        .mapToInt(e -> e)
                        .toArray();
        
        int ans = 0, sum = 0;
        for(int i : sortedIndices) {
            sum += plantTime[i];
            ans = Math.max(ans, sum + growTime[i]);
        }
        
        return ans;
    }
}