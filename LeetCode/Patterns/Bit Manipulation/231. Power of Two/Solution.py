class Solution(object):
    def isPowerOfTwo(self, n):
        if n<=0:
            return False
        if n==1:
            return True
        if n%2!=0:
            return False
        return self.isPowerOfTwo(n//2)
        # while n%2==0:
        #     n=n//2
        # return n==1 
        