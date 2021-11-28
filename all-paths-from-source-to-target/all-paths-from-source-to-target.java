class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return findPath(graph, 0);
    }
    
    public List<List<Integer>> findPath(int[][] graph, int curr) {
        int n = graph.length;
        
        if (curr == n - 1) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> val = new ArrayList<>();
            val.add(n - 1);
            res.add(val);
            return res;
        }
        
        if (graph[curr].length == 0) {
            return null;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        int[] adj = graph[curr];
        for(int i = 0; i < adj.length; i++) {
            List<List<Integer>> subpath = findPath(graph, adj[i]);
            if (subpath == null) {
                continue;
            }
            for(List<Integer> ls : subpath) {
                ls.add(0, curr);
                result.add(ls);
            }
        }
        
        return result;
    }
}