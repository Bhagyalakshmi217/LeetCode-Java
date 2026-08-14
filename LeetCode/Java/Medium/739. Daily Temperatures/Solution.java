// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n=temperatures.length;
//         int ans[]=new int[n];
//         Stack<Integer> stack=new Stack();
//         for(int i=0;i<n;i++){
//             while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
//                 int prevIndex=stack.pop();
//                 ans[prevIndex]=i-prevIndex;

//             }
//             stack.push(i);

//         }
//         return ans;
        
//     }
// }

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack=new ArrayDeque<>();
        int[] result=new int[temperatures.length];
        Arrays.fill(result,0);
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
            int index=stack.pop();
            result[index]=i-index;
            }
            stack.push(i);
        }
        return result;
    }
}