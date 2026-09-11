class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findCombination(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    }
    private void findCombination(int ind,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        // base case
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        // pick the current element
        if(arr[ind]<=target){
            ds.add(arr[ind]);
            findCombination(ind,arr,target-arr[ind],ans,ds);
            // backtrack
            ds.remove(ds.size()-1);
        }
        // not pick the current element
        findCombination(ind+1,arr,target,ans,ds);
    }
}