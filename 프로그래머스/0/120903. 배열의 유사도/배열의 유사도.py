def solution(s1, s2):
    answer = 0
    
    answer = len(set(s1) & set(s2))
    
    return answer