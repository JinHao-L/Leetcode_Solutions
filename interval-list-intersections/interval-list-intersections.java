class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        
        int n = firstList.length;
        int m = secondList.length;
        
        List<int[]> result = new ArrayList<>();
        while (i < n && j < m) {
            int[] top = firstList[i];
            int[] bottom = secondList[j];
            
            if (top[1] < bottom[0]) {
                i++;
            } else if (bottom[1] < top[0]) {
                j++;
            } else {
                int left = Math.max(top[0], bottom[0]);
                int right = Math.min(top[1], bottom[1]);
                result.add(new int[]{left, right});
                if (top[1] < bottom[1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        
        int[][] resArr = new int[result.size()][2];
        
        for(int k = 0; k < result.size(); k++) {
            resArr[k] = result.get(k);
        }
        return resArr;
    }
}