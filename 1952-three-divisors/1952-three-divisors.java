class Solution {
    public boolean isThree(int n) {
        if (n <= 3) return false;
        double root = Math.sqrt(n);
        int intRoot = (int) root;
        if (intRoot != root) return false;
        
        for(int i = 2; i <= Math.sqrt(intRoot); i++) {
            if (intRoot % i == 0 && intRoot / i != 1) {
                return false;
            }
        }
        
        return true;
    }
}