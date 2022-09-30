class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        
        for(int[] val : buildings) {
            heights.add(new int[]{val[0], val[2]});
            heights.add(new int[]{val[1], -val[2]});
        }
        
        Collections.sort(heights, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.add(0);

        List<List<Integer>> res = new ArrayList<>();
        int last = 0;
        for(int[] h : heights) {
            if (h[1] > 0) {
                pq.add(h[1]);
            } else {
                pq.remove(-h[1]);
            }
            
            int curr = pq.peek();
            if (curr != last) {
                res.add(List.of(h[0], curr));
                last = curr;
            }
        }
        
        return res;
    }
}