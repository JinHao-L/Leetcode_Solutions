class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int steps = 0;
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0, 0, k});
        
        int run;
        int res = Integer.MAX_VALUE;
        while ((run = q.size()) > 0) {
            boolean canEnd = false;
            for (int c = 0; c < run; c++) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];
                int ex = curr[2];
                
                if (i == m - 1 && j == n - 1) {
                    res = Math.min(steps, res);
                    canEnd = true;
                    continue;
                }

                if (canEnd || visited[i][j][ex]) continue;
                
                visited[i][j][ex] = true;
                
                for(int[] dir : new int[][]{{i - 1, j}, {i, j - 1}, {i + 1, j}, {i, j + 1}}) {
                    int ii = dir[0];
                    int jj = dir[1];
                    if (ii < 0 || jj < 0 || ii >= m || jj >= n) continue;
                    if (grid[ii][jj] == 1) {
                        if (ex > 0) q.offer(new int[]{ii, jj, ex - 1});
                    } else {
                        q.offer(new int[]{ii, jj, ex});
                    }
                }
            }
            if (canEnd) return res;
            steps++;
        }
        
        return -1;
    }
}