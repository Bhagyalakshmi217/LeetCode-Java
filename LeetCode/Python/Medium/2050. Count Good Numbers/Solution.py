class Solution(object):
    def countGoodNumbers(self, n):
        mod=10**9+7

        def power(x,y):
            result=1
            x=x%mod

            while y>0:
                if y%2==1:
                    result=(result*x)%mod
                x=(x*x)%mod
                y//=2
            return result
        even_position=(n+1)//2
        odd_position=n//2

        return (power(5,even_position)*power(4,odd_position))%mod
        