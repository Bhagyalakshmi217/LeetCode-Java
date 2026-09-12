class Solution {

    List<List<String>> ans = new ArrayList<>();

    HashSet<Integer> colSet = new HashSet<>();
    HashSet<Integer> diag1 = new HashSet<>();
    HashSet<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Initially fill with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, n, board);

        return ans;
    }

    private void solve(int row, int n, char[][] board) {

        // Base case
        if (row == n) {

            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            ans.add(current);
            return;
        }

        // Try every column
        for (int col = 0; col < n; col++) {

            // Check whether queen can be placed
            if (colSet.contains(col) ||
                diag1.contains(row - col) ||
                diag2.contains(row + col)) {

                continue;
            }

            // Place queen
            board[row][col] = 'Q';

            colSet.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            // Go to next row
            solve(row + 1, n, board);

            // Backtrack
            board[row][col] = '.';

            colSet.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}