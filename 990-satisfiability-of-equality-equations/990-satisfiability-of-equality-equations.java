class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] letters = new int[27];
        
        for(String s : equations) {
            int left = s.charAt(0) - 'a' + 1;
            int right = s.charAt(3) - 'a' + 1;

            int leftRoot = parent(letters, left);
            int rightRoot = parent(letters, right);

            if (s.charAt(1) == '=') {
                // ==
                if (rightRoot != leftRoot) {
                    letters[rightRoot] = leftRoot;
                }
            }
        }
        
        
        for(String s : equations) {
            int left = s.charAt(0) - 'a' + 1;
            int right = s.charAt(3) - 'a' + 1;
            int leftRoot = parent(letters, left);
            int rightRoot = parent(letters, right);

            if (s.charAt(1) == '!') {
                // ==
                if (leftRoot == rightRoot) {
                    return false;
                }
            }
        }
        
        
        return true;
    }
    
    public int parent(int[] letters, int query) {
        if (letters[query] == 0 || letters[query] == query) {
            return query;
        }
        int root = parent(letters,  letters[query]);
        return root;
    }
}