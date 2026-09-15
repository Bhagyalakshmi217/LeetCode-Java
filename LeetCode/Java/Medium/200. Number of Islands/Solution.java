import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1') {

                    count++;

                    bfs(grid, r, c, rows, cols);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int r, int c,
                     int rows, int cols) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{r, c});

        // Mark starting cell as visited
        grid[r][c] = '0';

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            // Try 4 directions
            for (int i = 0; i < 4; i++) {

                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                // Check boundary and land
                if (nextRow >= 0 && nextRow < rows &&
                    nextCol >= 0 && nextCol < cols &&
                    grid[nextRow][nextCol] == '1') {

                    grid[nextRow][nextCol] = '0';

                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}