class Solution {
    public String longestDupSubstring(String s) {
        int start = 1;
        int end = s.length();
        String res = "";
        while (start < end) {
            int mid = start + (end - start) / 2;
            String duplicate = findDuplicate(s, mid);
            if (duplicate.length() > 0) {
                res = duplicate;
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return res;
    }

    public String findDuplicate(String s, int m) {
        int n = s.length();
        long p = 2147483647;
        int d = 26;
        
        HashMap<Long, Integer> table = new HashMap();
        
        if (n <= m) {
            System.out.println("a");
            return "";
        }
        String result = "";
        long h = 1;

        for(int i = 0; i < m; i++) {
            h = (h*d) % p;
        }

        long pattern = 0;
        for(int i = 0; i < m; i++) {
            char c = s.charAt(i);
            pattern = (pattern * d + (c - 'a')) % p;
        }
        if (pattern < 0) {
            pattern += p;
        }
        table.put(pattern, 0);

        for(int i = 0; i < n - m; i++) {
            if (i < n - m) {
                pattern = (d * pattern + p) % p;
                pattern = (pattern - (s.charAt(i) - 'a') * h + p) % p;
                pattern = (pattern + (s.charAt(i + m) - 'a') + p) % p;
            }
            Integer start = table.get(pattern);
            
            if ((start != null) && (s.substring(i + 1, i + m + 1).equals(s.substring(start, start + m)))) {
                return s.substring(i + 1, i + m + 1);
            }
            table.put(pattern, i + 1);
        }
        return "";
    }
}