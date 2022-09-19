class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < paths.length; i++) {
            String[] tokens = paths[i].split(" ");
            String root = tokens[0];
            for(int j = 1; j < tokens.length; j++) {
                String[] file = tokens[j].split("\\(");
                List<String> ls = map.get(file[1]);
                if (ls == null) ls = new ArrayList<>();
                ls.add(root + "/" + file[0]);
                map.put(file[1], ls);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(List<String> vals: map.values()) {
            if (vals.size() > 1) ans.add(vals);
        }
        
        return ans;
    }
}