import math

def solution(n):
    answer = 0
    
    rt = math.isqrt(n)
    answer =  1 if (rt * rt == n) else 2
        
    return answer