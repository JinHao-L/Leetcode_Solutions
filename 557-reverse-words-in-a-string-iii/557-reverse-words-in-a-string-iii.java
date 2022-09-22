class Solution {
    public String reverseWords(String s) {
        int start = 0;
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        
        reverse(chars, start, chars.length - 1);
        
        return new String(chars);
    }
    
    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}