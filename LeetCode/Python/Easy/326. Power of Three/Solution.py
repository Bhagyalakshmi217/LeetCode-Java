class Solution(object):
    def isPowerOfThree(self, n):

        # if n<=0:
        #     return False
        # if n==1:
        #     return True
        # if n%3!=0:
        #     return False
        # return self.isPowerOfThree(n//3)
        if n<=0:
            return False
        while n%3==0:
            n//=3
        return n==1
        