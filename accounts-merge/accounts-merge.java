class UnionFind {
    int[] parents;
    
    public UnionFind(int n) {
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    
    public int union(int idx1, int idx2) {
        int root1 = findRoot(idx1);
        int root2 = findRoot(idx2);
        
        if (root1 == root2) {
            return root1;
        }
        
        parents[root2] = root1;
        return root1;
    }
    
    public int findRoot(int i) {
        if (parents[i] == i) {
            return i;
        } else {
            return parents[i] = findRoot(parents[i]);
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> reverse = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                Integer root2 = reverse.get(email);
                
                int root = i;
                if (root2 != null) {
                    root = uf.union(root, root2);
                }

                reverse.put(email, root);
            }
        }

        Map<Integer, List<String>> joined = new HashMap<>();
        for(Map.Entry<String, Integer> entry : reverse.entrySet()) {
            int root = uf.findRoot(entry.getValue());
            String email = entry.getKey();
            
            List<String> ls = joined.getOrDefault(root, new ArrayList<String>());
            ls.add(email);
            joined.put(root, ls);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<String> ls = joined.get(i);
            if (ls != null) {
                Collections.sort(ls);
                ls.add(0, accounts.get(i).get(0));
                result.add(ls);
            }
        }
        
        
        return result;
    }
}