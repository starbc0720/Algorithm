def solution(numbers):
    answer = 0
    
    tmp_answer = 0
    for num in numbers:
        tmp_answer += num
        
    answer = tmp_answer / len(numbers)
    return answer