class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for(int i = 0; i < s.length(); i++) {
                String possible = s.substring(i) + s.substring(0, i);
                if (possible.compareTo(ans) < 0) {
                    ans = possible;
                }
            }
            return ans;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}