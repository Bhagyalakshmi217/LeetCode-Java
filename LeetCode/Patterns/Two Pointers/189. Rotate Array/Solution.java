class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
// rev everything
        reverse(nums, 0, n - 1);

        // rev first k
        reverse(nums, 0, k - 1);

        // reverse remaining
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}