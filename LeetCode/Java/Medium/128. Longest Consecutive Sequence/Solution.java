class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int longest=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(!set.contains(num-1)){
                int count=1;
                while(set.contains(num+count)){
                    count++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
        
    }
}