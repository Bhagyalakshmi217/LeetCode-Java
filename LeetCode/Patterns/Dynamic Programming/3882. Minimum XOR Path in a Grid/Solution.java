
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxXor = 1024;

        boolean[][][] dp = new boolean[m][n][maxXor];

        // Starting cell
        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                // Move down: come from the cell above
                if (i > 0) {
                    for (int x = 0; x < maxXor; x++) {
                        if (dp[i - 1][j][x]) {
                            int newXor = x ^ grid[i][j];
                            dp[i][j][newXor] = true;
                        }
                    }
                }

                // Move right: come from the cell on the left
                if (j > 0) {
                    for (int x = 0; x < maxXor; x++) {
                        if (dp[i][j - 1][x]) {
                            int newXor = x ^ grid[i][j];
                            dp[i][j][newXor] = true;
                        }
                    }
                }
            }
        }

        // Find the minimum reachable XOR
        for (int x = 0; x < maxXor; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
