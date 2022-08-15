class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public Solution() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int sum = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            int val = map.get(arr[i]);
            
            if (i < arr.length - 1 && val < map.get(arr[i + 1])) {
                sum -= val;
            } else {
                sum += val;
            }
        }
        
        return sum;
    }
}