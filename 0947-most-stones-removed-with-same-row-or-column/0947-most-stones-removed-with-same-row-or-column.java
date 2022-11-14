class Solution {
    public int removeStones(int[][] stones) {
        // If they are connected, there must be some way to remove to 1
        // qn: how many connected groups are there
        HashMap<Integer, Integer> board = new HashMap<>();
        int[] parents = new int[stones.length];
        for(int i = 0; i < stones.length; i++) {
            parents[i] = i;
        }

        int nGroups = stones.length;
        for(int i = 0; i < stones.length; i++) {
            int xPos = stones[i][0] * 2;
            int yPos = stones[i][1] * 2 + 1;
            int xGrp = board.getOrDefault(xPos, -1);
            int yGrp = board.getOrDefault(yPos, -1);
            if (xGrp == -1 && yGrp == -1) {
                board.put(xPos, i);
                board.put(yPos, i);
            } else if (xGrp == -1 || yGrp == -1) {
                parents[i] = parents[Math.max(xGrp, yGrp)];
                board.put(xPos, parents[i]);
                board.put(yPos, parents[i]);
                nGroups--;
            } else {
                // union
                int xRoot = findParent(parents, xGrp);
                int yRoot = findParent(parents, yGrp);
                parents[yRoot] = xRoot;
                board.put(xPos, xRoot);
                board.put(yPos, xRoot);
                nGroups-= xRoot == yRoot ? 1 : 2;
            }
        }
        return stones.length - nGroups;
    }
    
    public int findParent(int[] parents, int curr) {
        if(curr == parents[curr]) return curr;
        parents[curr] = findParent(parents, parents[curr]);
        return parents[curr];
    }
}