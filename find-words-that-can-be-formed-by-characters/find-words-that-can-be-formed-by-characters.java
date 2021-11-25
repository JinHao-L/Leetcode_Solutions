class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        for(char c : chars.toCharArray()) {
            freq[(int)(c - 'a')]++;
        }
        
        int res = 0;
        for(String w : words) {
            int[] freq1 = new int[26];
            boolean valid = true;
            for(char c : w.toCharArray()) {
                int i = (int)(c - 'a');
                freq1[i]++;
                if (freq1[i] > freq[i]) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) {
                res += w.length();
            }
        }
        
        return res;
    }
}