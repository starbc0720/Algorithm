def solution(my_string):
    answer = ''
    
    answer = ''.join([ch for ch in my_string if ch not in 'aeiou'])
    return answer