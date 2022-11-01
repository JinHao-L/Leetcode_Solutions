class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = i;
        }
        
        for(int r = 0; r < grid.length; r++) {
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] == -1) {
                    continue;
                }
                
                if (grid[r][ans[i]] == 1) {
                    // redirect right
                    if (ans[i] == grid[0].length - 1) {
                        ans[i] = -1;
                    } else if (grid[r][ans[i] + 1] == -1) {
                        ans[i] = -1;
                    } else {
                        ans[i] = ans[i] + 1;
                    }
                } else {
                    // redirect left
                    if (ans[i] == 0) {
                        ans[i] = -1;
                    } else if (grid[r][ans[i] - 1] == 1) {
                        ans[i] = -1;
                    } else {
                        ans[i] = ans[i] - 1;
                    }
                }
                
            }
        }
        
        return ans;
    }
}