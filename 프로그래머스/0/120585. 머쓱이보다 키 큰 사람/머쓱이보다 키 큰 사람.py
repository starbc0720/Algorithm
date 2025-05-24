def solution(array, height):
    answer = 0
    
    answer = sum(1 for arr in array if arr > height)
    return answer