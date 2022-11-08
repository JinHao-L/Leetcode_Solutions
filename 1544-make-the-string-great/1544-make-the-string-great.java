class Solution {
    public String makeGood(String s) {
        int n = s.length();
        
        for (int i = 0; i < n - 1; i++) {
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            if ((curr >= 'a' && curr - 'a' == next - 'A') ||
               (curr < 'a' && curr - 'A' == next - 'a')) {
                return makeGood(s.substring(0, i) + s.substring(i + 2));
            }
        }
        
        return s;
    }
}