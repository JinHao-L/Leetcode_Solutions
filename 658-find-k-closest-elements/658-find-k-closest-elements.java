class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - 1;
        
        while (end - start + 1 > k) {
            if (Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) {
                end--;
            } else {
                start++;
            }
        }
        
        List<Integer> ls = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            ls.add(arr[i]);
        }
        
        return ls;
    }
}