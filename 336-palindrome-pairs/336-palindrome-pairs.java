class Solution {
    class Node {
        public int pos;
        public Node[] next;
        public List<Integer> palindromes;
        
        public Node() {
            pos = -1;
            palindromes = new ArrayList<>();
            next = new Node[27];
        }
        
        public void add(char[] chars, int charIdx, int wordIdx) {
            if (charIdx >= chars.length) {
                pos = wordIdx;
                return;
            };
            
            int idx = chars[charIdx] - 'a';
            if (next[idx] == null) {
                next[idx] = new Node();
            }

            Node nextNode = next[idx];
            nextNode.add(chars, charIdx + 1, wordIdx);
            
            if (isPalindrome(chars, charIdx, chars.length - 1)) {
                palindromes.add(wordIdx);
            }
        }
        
    }
    
    public boolean isPalindrome(char[] chars, int start, int end) {
        while(start < end && chars[start] == chars[end]) {
            start++;
            end--;
        }
        return start >= end;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Node root = new Node();
        
        for(int i = 0; i < words.length; i++) {
            root.add(words[i].toCharArray(), 0, i);
        }
        
        for(int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Node curr = root;
            int j = chars.length - 1;
            for(; j >= 0 && curr != null; j--) {
                if (curr.pos != -1 && isPalindrome(chars, 0, j)) {
                    res.add(Arrays.asList(curr.pos, i));
                }
                curr = curr.next[chars[j] - 'a'];
            }

            if (curr != null && isPalindrome(chars, 0, j)) {
                for(int k : curr.palindromes) {
                    if (k != i) res.add(Arrays.asList(k, i));
                }
                
                if (curr.pos != -1 && curr.pos != i) {
                    res.add(Arrays.asList(curr.pos, i));
                }
            }
        }
        
        return res;
    }
}
