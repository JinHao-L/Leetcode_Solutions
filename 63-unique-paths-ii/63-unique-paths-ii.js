/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    const n = obstacleGrid.length
    const m = obstacleGrid[0].length;
    let prev = new Array(m + 1).fill(0);
    let curr = new Array(m + 1).fill(0);
    curr[0] = 1;
    
    for(let i = 0; i < n; i++) {
        for(let j = 1; j <= m; j++) {
            if (!obstacleGrid[i][j-1]){
                curr[j] = prev[j] + curr[j - 1];
            }
        }
        prev = curr;
        curr = new Array(m + 1).fill(0);
    }
    
    return prev[m];
};