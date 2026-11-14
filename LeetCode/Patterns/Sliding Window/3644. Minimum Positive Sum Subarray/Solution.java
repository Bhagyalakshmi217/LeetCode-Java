class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        // Step 1: Build prefix sum
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        // Step 2: Find minimum positive subarray sum
        int minSum = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {

                int length = end - start + 1;

                if (length >= l && length <= r) {
                    int sum = prefix[end + 1] - prefix[start];

                    if (sum > 0) {
                        minSum = Math.min(minSum, sum);
                    }
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}