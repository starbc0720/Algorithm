def solution(my_string, n):
    answer = ''
            
    answer = ''.join(n * char for char in my_string)
    return answer