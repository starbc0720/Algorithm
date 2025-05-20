def solution(str1, str2):
    answer = 0
    
    str1 = str1.lower()
    str2 = str2.lower()
    
    if str2 in str1:
        answer = 1
    else:
        answer = 2
    return answer