class Solution {
    boolean[] visited = new boolean[50000];
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if (start < 0 || start >= n || visited[start]) {
            return false;
        }
        
        if (arr[start] == 0) {
            return true;
        }
        
        visited[start] = true;
        
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}