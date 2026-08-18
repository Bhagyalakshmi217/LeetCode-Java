// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int first=find(nums,target,true);
//         int last=find(nums,target,false);
//         return new int[]{first,last};

        
//     }
//     int find(int nums[],int target,boolean firstOccurence){
//         int left=0;
//         int right=nums.length-1;
//         int mid;
//         int answer=-1;

//         while(left<=right){
//             mid=left+(right-left)/2;

//             if(nums[mid]==target){
//                 answer=mid;

//                 if(firstOccurence){
//                     right=mid-1;
//                 }else{
//                     left=mid+1;
//                 }
//             }
//             else if(nums[mid]<target){
//                 left=mid+1;
//             }
//             else{
//                 right=mid-1;
//             }


//         }
//         return answer;
//     }
// }


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findFirst(nums,target);
        int last=findLast(nums,target);
        return new int[]{first,last};
    }
    int findFirst(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int answer=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                answer=mid;
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return answer;
    }
    int findLast(int[] nums,int target){
        int left=0;int right=nums.length-1;
        int answer=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                answer=mid;
                left=mid+1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return answer;
    }
    
}