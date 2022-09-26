class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] letters = new int[27];
        
        for(String s : equations) {
            int leftRoot = parent(letters, s.charAt(0) - 'a' + 1);
            int rightRoot = parent(letters, s.charAt(3) - 'a' + 1);

            if (s.charAt(1) == '=') {
                letters[rightRoot] = leftRoot;
            }
        }
        
        for(String s : equations) {
            int leftRoot = parent(letters, s.charAt(0) - 'a' + 1);
            int rightRoot = parent(letters, s.charAt(3) - 'a' + 1);

            if (s.charAt(1) == '!' && leftRoot == rightRoot) {
                return false;
            }
        }
        
        return true;
    }
    
    public int parent(int[] letters, int query) {
        if (letters[query] == 0 || letters[query] == query) {
            return query;
        }
        int root = parent(letters,  letters[query]);
        letters[query] = root;
        return root;
    }
}