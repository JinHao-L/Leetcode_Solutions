class Solution {
    public int maximum69Number (int num) {
        int curr = 1000;
        while (curr >= 1) {
            if ((num / curr) % 10 == 6) {
                return num + 3 * curr;
            }
            curr = curr / 10;
        }
        
        return num;
    }
}