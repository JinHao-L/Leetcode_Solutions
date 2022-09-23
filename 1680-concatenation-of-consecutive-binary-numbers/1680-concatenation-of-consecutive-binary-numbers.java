class Solution {
    public int concatenatedBinary(int n) {
        long mod = (long) (1e9 + 7);
        int bitLen = 0;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) bitLen++;
            res = ((res << bitLen) + i) % mod;
        }
        
        return (int) res;
    }
}