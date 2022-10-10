class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        for(int i = 0; i < len / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }
        for(int i = len - 1; i >= (int)Math.ceil(len / 2.0); i--) {
            if (palindrome.charAt(i) != 'b') {
                return palindrome.substring(0, i) + 'b' + palindrome.substring(i + 1);
            }
        }
        
        return "";
    }
}
