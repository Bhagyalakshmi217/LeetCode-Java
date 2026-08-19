class Solution(object):
    def shipWithinDays(self, weights, days):
        left, right = max(weights), sum(weights)
    
        while left < right:
            mid = (left + right) // 2
            if canShip(weights, days, mid):
                right = mid
            else:
                left = mid + 1
            
        return left

def canShip(weights, days, capacity):
    total = 0
    required_days = 1
    for w in weights:
        if total + w > capacity:
            required_days += 1
            total = 0
        total += w
    return required_days <= days
        
        
        