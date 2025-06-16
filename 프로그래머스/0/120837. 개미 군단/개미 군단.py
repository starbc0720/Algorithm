def solution(hp):
    answer = 0
    
    while hp > 0:
        tmp_cnt = 0
        if hp // 5 > 0:
            tmp_cnt = hp // 5
            hp = hp - (5 * tmp_cnt)
        elif hp // 3 > 0:
            tmp_cnt = hp // 3
            hp = hp - (3 * tmp_cnt)
        else:
            answer = answer + hp
            hp = 0
        
        answer += tmp_cnt
    
    return answer