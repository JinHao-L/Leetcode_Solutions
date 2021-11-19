class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }
    
    public boolean solveSudoku(char[][] board, int r, int c) {
        if (r >= 8 && c >= 9) {
            return true;
        }
        
        if (c >= 9) {
            return solveSudoku(board, r + 1, c % 9);
        }
        
        if (board[r][c] != '.') {
            return solveSudoku(board, r, c + 1);
        }
        
        for(int v = 1; v <= 9; v++) {
            char val = (char) (v + '0');
            if (isValidMove(board, r, c, val)) {
                board[r][c] = val;
                if (solveSudoku(board, r, c + 1)) {
                    return true;
                } else {
                    board[r][c] = '.';
                }
            }
        }
        return false;
    }
    
    
    public boolean isValidMove(char[][] board, int r, int c, char val) {
        // check rows
        for(int i = 0; i < 9; i++) {
            if (board[i][c] == val) {
                return false;
            }
        }
        
        // check cols
        for(int i = 0; i < 9; i++) {
            if (board[r][i] == val) {
                return false;
            }
        }
        
        // check square
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int nr = (r / 3) * 3 + i;
                int nc = (c / 3) * 3 + j;

                if (board[nr][nc] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}