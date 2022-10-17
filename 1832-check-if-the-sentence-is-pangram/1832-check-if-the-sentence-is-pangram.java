class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> seen = new HashSet<>();
        
        for (char i : sentence.toCharArray()) {
            seen.add(i);
            if (seen.size() == 26) return true;
        }
        return seen.size() == 26;
    }
}