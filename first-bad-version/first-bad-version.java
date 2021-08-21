/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 0;
        
        while (s < n) {
            int mid = s + (n - s) / 2;
            boolean isBad = isBadVersion(mid);
            
            if (isBad) {
                n = mid;
            } else {
                s = mid + 1;
            }
        }
        
        return s;
    }
}