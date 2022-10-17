class Solution {
    public boolean checkIfPangram(String sentence) {
        BitSet state = new BitSet(26);
        state.set(0, 26);
        
        for (char i : sentence.toCharArray()) {
            state.set(i - 'a', false);
            if (state.cardinality() == 0) return true;
        }
        return state.cardinality() == 0;
    }
}