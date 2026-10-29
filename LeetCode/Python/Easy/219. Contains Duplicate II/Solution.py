class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        # n=len(nums)

        # for i in range(n):
        #     for j in range(i+1,n):
        #         if nums[i]==nums[j] and abs(i-j)<=k:
        #             return True
        # return False
        window=set()
        for i in range(len(nums)):
            if nums[i] in window:
                return True
            window.add(nums[i])

            if len(window)>k:
                window.remove(nums[i-k])
        return False

        