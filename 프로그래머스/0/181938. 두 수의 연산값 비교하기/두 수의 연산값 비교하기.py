def solution(a, b):
    answer = 0
    
    add_num = str(a) + str(b)
    add_num = int(add_num)
    
    mul_num = 2 * a * b
    
    if add_num > mul_num:
        answer = add_num
    else:
        answer = mul_num
        
    return answer