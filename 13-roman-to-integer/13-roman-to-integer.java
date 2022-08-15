class Solution {
    static final String[] SYM = {"IV", "IX", "XL", "XC", "CD", "CM", "M", "D", "C", "L", "X", "V", "I"};
    static final int[] VAL = {4, 9, 40, 90, 400, 900, 1000, 500, 100, 50, 10, 5, 1};
    
    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        
        for(int i = 0; i < SYM.length; i++) {
            if (s.startsWith(SYM[i])) {
                return VAL[i] + romanToInt(s.substring(SYM[i].length()));
            }
        }
        
        return 0;
    }
}