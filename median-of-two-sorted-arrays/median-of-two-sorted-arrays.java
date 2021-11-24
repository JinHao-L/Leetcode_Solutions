class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
    
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        boolean isOdd = (m + n) % 2 == 1;
        int half = (m + n) / 2;
    
        if (m == 0) {
            return isOdd
                ? nums2[half]
                : ((double) nums2[half - 1] + nums2[half]) / 2;
        }
        
        int l = 0;
        int r = m;

        while (l <= r) {
            int mid1 = l + (r - l) / 2;
            int mid2 = half - mid1;
            
            int l1 = mid1 <= 0 ? -1000001 : nums1[mid1 - 1];
            int r1 = mid1 >= m ? 1000001 : nums1[mid1];
            int l2 = mid2 <= 0 ? -1000001 : nums2[mid2 - 1];
            int r2 = mid2 >= n ? 1000001 : nums2[mid2];
        
            if (l1 > r2) {
                r = mid1 - 1;
                
            } else if (l2 > r1) {
                l = mid1 + 1;
                
            } else if (isOdd) {
                return Math.min(r1, r2);
                
            } else {
                return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                
            }
        }
        return 0.0;
    }
}