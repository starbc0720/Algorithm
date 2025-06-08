def solution(money):
    answer = []
    
    coffee = int(money / 5500)
    remain = money % 5500
    
    answer.append(coffee)
    answer.append(remain)
    
    return answer