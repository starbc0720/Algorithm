def solution(price):
    answer = 0
    
    discount = 0
    if price >= 100000 and price < 300000:
        discount = 0.95
    elif price >= 300000 and price < 500000:
        discount = 0.9
    elif price >= 500000:
        discount = 0.8
    else:
        discount = 1
        
    answer = int(price * discount)
    return answer