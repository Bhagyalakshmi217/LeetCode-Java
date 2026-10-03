class Solution {
    public boolean canCross(int[] stones) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        Boolean[][] dp = new Boolean[stones.length][stones.length + 1];

        return solve(0, 0, stones, map, dp);
    }

    private boolean solve(
        int index,
        int lastJump,
        int[] stones,
        Map<Integer, Integer> map,
        Boolean[][] dp) {

        if (index == stones.length - 1) {
            return true;
        }

        if (dp[index][lastJump] != null) {
            return dp[index][lastJump];
        }

        for (int jump = lastJump - 1;
             jump <= lastJump + 1;
             jump++) {

            if (jump <= 0) {
                continue;
            }

            int nextPosition = stones[index] + jump;

            if (map.containsKey(nextPosition)) {

                int nextIndex = map.get(nextPosition);

                if (solve(nextIndex, jump, stones, map, dp)) {
                    return dp[index][lastJump] = true;
                }
            }
        }

        return dp[index][lastJump] = false;
    }
}