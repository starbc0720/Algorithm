def solution(slice, n):
    answer = 0
    
    if n < slice:
        answer = 1
    else:
        answer = int(n / slice) + 1 if n % slice > 0 else n / slice
    return answer