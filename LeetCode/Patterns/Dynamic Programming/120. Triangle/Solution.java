// class Solution {
//     int[][] dp;

//     int f(int i, int j, int n, List<List<Integer>> triangle, int[][] dp) {
//         if (i == n - 1) {
//             return triangle.get(n - 1).get(j);
//         }

//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }

//         int d = triangle.get(i).get(j) + f(i + 1, j, n, triangle, dp);
//         int dg = triangle.get(i).get(j) + f(i + 1, j + 1, n, triangle, dp);

//         return dp[i][j] = Math.min(d, dg);
//     }

//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();

//         dp = new int[n][n];

//         for (int j = 0; j < n; j++) {
//             dp[n - 1][j] = triangle.get(n - 1).get(j);
//         }

//         for (int i = n - 2; i >= 0; i--) {
//             for (int j = i; j >= 0; j--) {
//                 int d = triangle.get(i).get(j) + dp[i + 1][j];
//                 int dg = triangle.get(i).get(j) + dp[i + 1][j + 1];

//                 dp[i][j] = Math.min(d, dg);
//             }
//         }

//         return dp[0][0];
//     }
// }


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[] front = new int[n];

        // Last row
        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j);
        }

        // Bottom to top
        for (int i = n - 2; i >= 0; i--) {

            int[] cur = new int[n];

            for (int j = i; j >= 0; j--) {

                int d = triangle.get(i).get(j) + front[j];

                int dg = triangle.get(i).get(j) + front[j + 1];

                cur[j] = Math.min(d, dg);
            }

            front = cur;
        }

        return front[0];
    }
}