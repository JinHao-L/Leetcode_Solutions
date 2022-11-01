class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        List<List<Integer>> slots = new ArrayList<>(n);
        List<List<Integer>> next = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            slots.add(new ArrayList<Integer>());
            next.add(new ArrayList<Integer>());
            slots.get(i).add(i);
        }
        
        for(int[] row: grid) {
            boolean hasBall = false;
            
            for(int i = 0; i < n; i++) {
                if (slots.get(i).isEmpty()) {
                    continue;
                } else if (row[i] == -1 && i != 0 && row[i - 1] == -1) {
                    next.get(i - 1).addAll(slots.get(i));
                    hasBall = true;
                } else if (row[i] == 1 && i != n - 1 && row[i + 1] == 1){
                    next.get(i + 1).addAll(slots.get(i));
                    hasBall = true;
                }
                slots.get(i).clear();
            }

            if (!hasBall) {
                return ans;
            } else {
                List<List<Integer>> tmp = next;
                next = slots;
                slots = tmp;
            }
        }
        
        for(int pos = 0; pos < n; pos++) {
            for (int ball: slots.get(pos)) {
                ans[ball] = pos;
            }
        }
        
        return ans;
    }
}