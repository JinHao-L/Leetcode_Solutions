class Solution {
  int n;
  List<List<String>> solution;

  public List<List<String>> solveNQueens(int n) {
    this.n = n;
    this.solution = new ArrayList<List<String>>();
    int[] variables = new int[n];
    Arrays.fill(variables, -1);
    boolean[][] restrictions = new boolean[n][n];

    backtrack(variables, restrictions);
    return solution;
  }

  public int[] backtrack(int[] variables, boolean[][] restrictions) {
    int target = -1;
    for (int i = 0; i < this.n; i++) {
      if (variables[i] == -1) {
        target = i;
        break;
      }
    }

    if (target == -1) {
      addToSolution(variables);
      return variables;
    }

    for (int j = 0; j < this.n; j++) {
      if (!restrictions[target][j]) {
        variables[target] = j;


        boolean[][] newRestrictions = infer(restrictions, target, j);
        if (newRestrictions != null) {
          backtrack(variables, newRestrictions);
        }

        variables[target] = -1;   
      }
    }
    return null;
  }

  public boolean[][] infer(boolean[][] restrictions, int target, int value) {
    boolean[][] copy = new boolean[this.n][this.n];
    int diagLeft = value; 
    int diagRight = value;
    for(int i = 0; i < this.n; i++) {
      if (i > target) {
        copy[i][value] = true;
        if (diagLeft > 0) {
          copy[i][--diagLeft] = true;
        }

        if (diagRight < this.n - 1) {
          copy[i][++diagRight] = true;
        }
      }

      boolean hasFalse = false;
      for(int j = 0; j < this.n; j++) {
        copy[i][j] = copy[i][j] || restrictions[i][j];
        hasFalse = hasFalse || !copy[i][j];
      }

      if (!hasFalse) {
        return null;
      }
    }

    return copy;
  }

  public void addToSolution(int[] variables) {
    List<String> board = new ArrayList<String>();
    for(int i = 0; i < this.n; i++) {
      char[] row = new char[n];
      for (int j = 0; j < this.n; j++) {
        row[j] = '.';
      }
      if (variables[i] != -1) {
        row[variables[i]] = 'Q';
      }
      board.add(new String(row));
    }
    this.solution.add(board);
    return;
  }
}