class Solution {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[26 + 26];
        int[] sFreq = new int[26 + 26];
        int count = t.length();
        
        for(char c: t.toCharArray()) {
            tFreq[charToIndex(c)]++;
        }
        
        int start = 0, end = 0;
        int captured = 0;
        int bestLen = s.length() + 1;
        int bestStart = -1;
        while (end < s.length() || captured == count) {
            if (captured < count) {
                char c = s.charAt(end);
                if (tFreq[charToIndex(c)] > 0 ) {
                    sFreq[charToIndex(c)]++;
                    if (sFreq[charToIndex(c)] <= tFreq[charToIndex(c)]) captured++;
                }
                end++;
            } else {
                if (end - start < bestLen) {
                    bestLen = end - start;
                    bestStart = start;
                }
                char c = s.charAt(start);

                if (tFreq[charToIndex(c)] > 0) {
                    sFreq[charToIndex(c)]--;
                    if (sFreq[charToIndex(c)] < tFreq[charToIndex(c)]) captured--;
                }
                start++;
            }
        }
        
        if (bestStart == -1) return "";
        return s.substring(bestStart, bestStart + bestLen);
    }
    
    public int charToIndex(char c) {
        if (c <= 'Z') return c - 'A';
        return c - 'a' + 26;
    }
}