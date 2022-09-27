class Solution {
    public String pushDominoes(String dominoes) {
        char[] state = dominoes.toCharArray();
        
        char prevType = 'L';
        int prevPos = 0;
        for(int i = 0; i < state.length; i++) {
            if (state[i] == 'L') {
                if (prevType == 'R') {
                    int mid = (prevPos + i) / 2;
                    fill(state, prevPos, (prevPos + i) % 2 == 0 ? mid - 1 : mid + 1, 'R');
                    fill(state, mid + 1, i, 'L');
                } else {
                    fill(state, prevPos, i, 'L');
                }
            } else if (state[i] == 'R') {
                if (prevType == 'R') {
                    fill(state, prevPos, i, 'R');
                }
            }
            
            if (state[i] != '.') {
                prevType = state[i];
                prevPos = i;
            }
        }
        
        if (prevType == 'R') {
            fill(state, prevPos, state.length - 1, 'R');
        }
        
        return new String(state);
    }
    
    public void fill(char[] arr, int start, int end, char val) {
        while(start <= end) {
            arr[start++] = val;
        }
    }
}