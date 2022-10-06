class TimeMap {
    HashMap<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Pair(timestamp, value));
        } else {
            map.put(key, new ArrayList<Pair<Integer, String>>(){
                {
                    if (timestamp != 0) add(new Pair(0, ""));
                    add(new Pair(timestamp, value));
                }
            });
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<Integer, String>> ls = map.get(key);
        int start = 0;
        int end = ls.size() - 1;
        
        while (start < end) {
            int mid = (int) Math.ceil((end + start) / 2.0);
            int midKey = ls.get(mid).getKey();
            if (midKey == timestamp) {
                start = mid;
                break;
            } else if (midKey > timestamp) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        
        return ls.get(start).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */