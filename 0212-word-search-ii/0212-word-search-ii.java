class TrieNode {
    char c;
    boolean isEnd;
    HashMap<Character, TrieNode> children = new HashMap<>();

    TrieNode(char c) {
        this.c = c;
        this.isEnd = false;
    }

    void add(String word, int i) {
        char curr = word.charAt(i);
        TrieNode next = children.getOrDefault(curr, new TrieNode(curr));
        if (i == word.length() - 1) {
            next.isEnd = true;
        } else {
            next.add(word, i + 1);
        }
        children.put(curr, next);
    }

    TrieNode popTrie(char c) {
        return children.remove(c);
    }

    void pushTrie(TrieNode node) {
        children.put(node.c, node);
    }

    boolean isEmpty() {
        return this.children.isEmpty();
    }
}

class Solution {
    int m, n;
    char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        TrieNode root = new TrieNode('0');
    
        for(String w: words) {
            root.add(w, 0);
        }

        List<String> ans = new ArrayList<>();
        boolean[][] seen = new boolean[m][n];
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < this.m; i++) {
            for(int j = 0; j < this.n; j++) {
                TrieNode start = root.popTrie(board[i][j]);
                if (start != null) {
                    search(i, j, start, seen, curr, ans);
                    root.pushTrie(start);
                }
            }
        }
        return ans;
    }

    public boolean search(int i, int j, TrieNode node, boolean[][] seen, StringBuilder curr, List<String> ans) {
        seen[i][j] = true;
        if (node.c != '0')
            curr.append(node.c);
        if (node.isEnd) {
            ans.add(curr.toString());
            node.isEnd = false;
        }

        int[][] adjacents = new int[][]{{i + 1, j}, {i - 1, j}, {i, j + 1}, {i, j - 1}};

        for(int[] pos : adjacents) {
            int ii = pos[0];
            int jj = pos[1];
            if (ii < 0 || jj < 0 || ii >= m || jj >= n || seen[ii][jj]) continue;
            TrieNode next = node.popTrie(this.board[ii][jj]);
            if (next != null && !search(ii, jj, next, seen, curr, ans)) {
                node.pushTrie(next);
            }
        }
        
        if (node.c != '0')
            curr.deleteCharAt(curr.length() - 1);
        seen[i][j] = false;

        return node.isEmpty();
    }
}