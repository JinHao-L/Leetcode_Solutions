class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        
        for (String word: words) {
            freq.merge(word, 1, Integer::sum);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> {
                int diff = a.getValue().compareTo(b.getValue());
                if (diff == 0) {
                    return b.getKey().compareTo(a.getKey());
                }
                return diff;
            }
        );
        
        for (Map.Entry entry: freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<String> ls = new ArrayList<>();
        while(pq.size() > 0) {
            ls.add(pq.poll().getKey());
        }
        
        Collections.reverse(ls);
        return ls;
    }
}