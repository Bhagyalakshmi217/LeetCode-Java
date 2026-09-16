import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        // Put all 0s into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int row = current[0];
            int col = current[1];
            int steps = current[2];

            distance[row][col] = steps;

            // Check 4 directions
            for (int i = 0; i < 4; i++) {

                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1;

                    q.offer(new int[]{nrow, ncol, steps + 1});
                }
            }
        }

        return distance;
    }
}