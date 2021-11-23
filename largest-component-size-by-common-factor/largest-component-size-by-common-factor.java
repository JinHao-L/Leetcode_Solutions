class UnionFind {
    int[] parent;
    int[] size;
    int max;
    
    public UnionFind (int N){
        parent = new int[N];
        size = new int[N];
        max = 1;
        for (int i = 0; i < N; i++){
            parent[i] = i;
            size[i] = 0;
        }
    }
    public int find(int x){
        if (x == parent[x]){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
            max = Math.max(max, size[rootY]);
        }
    }
    public void increment(int x){
        int rootX = find(x);
        size[rootX]+=1;
        max = Math.max(max, size[rootX]);
    }
}

class Solution {
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(100001);
        for(int i = 0; i < n; i++) {
            int val = nums[i];
            uf.increment(val);
            for(int f = 2; f * f <= nums[i]; f++) {
                if (val % f == 0) {
                    uf.union(nums[i], f);
                    while (val % f == 0) val /= f;
                }
            }
            if (val > 1) {
                uf.union(val, nums[i]);
            }
        }
        return uf.max;
    }
}