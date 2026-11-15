class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        // sum is for when it encounters odd  numbers
        int sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                sum++;
            }
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return count;
        
    }
}