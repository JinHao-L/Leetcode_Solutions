class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length == 0 || changed.length % 2 == 1) {
            return new int[0];
        }
        Arrays.sort(changed);
        int[] res = new int[changed.length / 2];
        Arrays.fill(res, -1);
        int ogPointer = 0;
        int end = 0;
        
        for(int i = 0; i < changed.length; i++) {
            int curr = changed[i];
            int target = res[ogPointer] * 2;
            if (res[ogPointer] == -1 || target > curr) {
                if (end >= res.length) return new int[0];
                res[end++] = curr;
            } else if (target == curr) {
                ogPointer++;
            } else {
                return new int[0];
            }
        }
        return res;
    }
}