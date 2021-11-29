class Solution:
    def climbStairs(self, n: int) -> int:
        (prevprev, prev) = (0, 1);

        for i in range(n):
            (prevprev, prev) = (prev, prevprev + prev)
        
        return prev;
        