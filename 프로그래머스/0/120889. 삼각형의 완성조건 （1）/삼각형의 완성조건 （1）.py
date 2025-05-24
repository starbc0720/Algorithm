def solution(sides):
    answer = 0    
    
    sides.sort()
    
    c = sides.pop() #가장 긴 변
    ab = sum(s for s in sides)
    
    if ab <= c:
        answer = 2
    else:
        answer = 1
    
    return answer