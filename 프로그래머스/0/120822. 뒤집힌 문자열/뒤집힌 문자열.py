def solution(my_string):
    answer = ''
    
    tmp_answer = []
    for str in my_string:
        tmp_answer.insert(0, str)
    
    answer = ''.join(tmp_answer)
    
    return answer