class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        int curr = 0;
        while(num > 0) {
            if (num >= values[curr]) {
                num = num - values[curr];
                ans.append(roman[curr]);
            } else {
                curr++;
            }
        }
        
        return ans.toString();
    }
}