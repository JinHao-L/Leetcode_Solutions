class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        
        int max = m * n;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int top = j == 0 ? max : res[i][j - 1];
                int left = i == 0 ? max : res[i - 1][j];
                res[i][j] = mat[i][j] == 0 ? 0 : Math.min(top, left) + 1;
            }
        }

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int bottom = j == n - 1 ? max : res[i][j + 1];
                int right = i == m - 1 ? max : res[i + 1][j];
                res[i][j] = Math.min(res[i][j], Math.min(bottom, right) + 1);
            }
        }
        
        return res;
    }
}