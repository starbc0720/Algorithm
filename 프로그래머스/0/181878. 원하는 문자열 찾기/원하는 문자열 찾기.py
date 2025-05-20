def solution(myString, pat):
    answer = 0
    
    myString = myString.upper()
    pat = pat.upper()
    
    if pat in myString:
        answer = 1
    else:
        answer = 0
    
    return answer