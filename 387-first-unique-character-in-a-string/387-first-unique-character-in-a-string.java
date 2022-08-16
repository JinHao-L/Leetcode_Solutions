class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (arr[c] == 0) {
                arr[c] = i + 1;
            } else {
                arr[c] = -1;
            }
        }
        
        int minIdx = 0;
        for(int i = 0; i < 26; i++) {
            if (arr[i] > 0 && (minIdx == 0 || arr[i] < minIdx)) {
                minIdx = arr[i];
            }
        }
        return minIdx - 1;
    }
}