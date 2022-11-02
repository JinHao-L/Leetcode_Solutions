class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> currBank = new HashSet<>();
        for(String valid: bank)
            currBank.add(valid);
        
        if (!currBank.contains(end))
            return -1;
        
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int mutations = 0;
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            mutations++;
            for(int j = 0; j < qSize; j++) {
                String curr = q.poll();
                currBank.remove(curr);
                StringBuilder node = new StringBuilder(curr);

                for(int i = 0; i < 8; i++) {
                    char saved = node.charAt(i);
                    for(char c: new char[]{'A', 'C', 'G', 'T'}) {
                        node.setCharAt(i, c);
                        String next = node.toString();
                        if (next.equals(end))
                            return mutations;
                        if (currBank.contains(next))
                            q.offer(next);
                    }
                    node.setCharAt(i, saved);
                }
            }
        }
        
        return -1;
    }
}