class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        int p = 1000000007;
        int m = 10;
        int d = 4;
        
        HashMap<Integer,Integer> table = new HashMap();
        List<String> result = new ArrayList();
        
        if (n <= 10) {
            return result;
        }
        
        int offset = ((int) Math.pow(d, m)) % p;

        int pattern = 0;
        for(int i = 0; i < m; i++) {
            char c = s.charAt(i);
            pattern = (pattern * 4 + charToInt(c)) % p;
        }
        table.put(pattern, table.getOrDefault(pattern, 0) + 1);

        for(int i = 0; i < n - m; i++) {
            if (i < n - m) {
                pattern = (d * pattern - charToInt(s.charAt(i)) * offset  + charToInt(s.charAt(i + m))) % p;
                if (pattern < 0) {
                    pattern += p;
                }
            }
            int freq = table.getOrDefault(pattern, 0) + 1;
            table.put(pattern, freq);
            if (freq == 2) {
                result.add(s.substring(i + 1, i + 1 + m));
            }
        }
        return result;
    }

    public int charToInt(char c) {
        switch(c){
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return 0;
    }
}