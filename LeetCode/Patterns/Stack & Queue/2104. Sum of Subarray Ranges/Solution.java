// class Solution {
//     public long subArrayRanges(int[] nums) {
//         Deque<Integer> stack=new ArrayDeque<>();
//         int[] left=new int[nums.length];
//         int[] right=new int[nums.length];
//         long sumMax=0;
//         long sumMin=0;
//         long ans=0;
//         for(int i=0;i<nums.length;i++){
//             while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
//                 stack.pop();
//             }
//             left[i]=stack.isEmpty()?-1:stack.peek();
//             stack.push(i);
//         }
//         stack.clear();
//         for(int i=nums.length-1;i>=0;i--){
//             while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
//                 stack.pop();
//             }
//             right[i]=stack.isEmpty()?nums.length:stack.peek();
//             stack.push(i);
//         }
//         for(int i=0;i<nums.length;i++){
//             long contribution=(long)nums[i]*(i-left[i])*(right[i]-i);
//             sumMin+=contribution;
//         }


//         for(int i=0;i<nums.length;i++){
//             while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
//                 stack.pop();
//             }
//             left[i]=stack.isEmpty()?-1:stack.peek();
//             stack.push(i);
//         }
//         stack.clear();
//         for(int i=nums.length-1;i>=0;i--){
//             while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
//                 stack.pop();
//             }
//             right[i]=stack.isEmpty()?nums.length:stack.peek();
//             stack.push(i);
//         }
//         for(int i=0;i<nums.length;i++){
//             long contribution=(long)nums[i]*(i-left[i])*(right[i]-i);
//             sumMax+=contribution;
//         }
//         ans=sumMax-sumMin;
//         return (int)ans;



//         }
// }


class Solution {
    public long subArrayRanges(int[] nums) {

        int n = nums.length;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];

        long sumMin = 0;
        long sumMax = 0;

        // ---------------- MINIMUM ----------------

        // Previous Smaller or Equal
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Strictly Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Sum of minimums
        for (int i = 0; i < n; i++) {

            long contribution =
                (long) nums[i]
                * (i - left[i])
                * (right[i] - i);

            sumMin += contribution;
        }

        // ---------------- MAXIMUM ----------------

        stack.clear();

        // Previous Greater or Equal
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Strictly Greater
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Sum of maximums
        for (int i = 0; i < n; i++) {

            long contribution =
                (long) nums[i]
                * (i - left[i])
                * (right[i] - i);

            sumMax += contribution;
        }

        // Range = maximum - minimum
        return sumMax - sumMin;
    }
}