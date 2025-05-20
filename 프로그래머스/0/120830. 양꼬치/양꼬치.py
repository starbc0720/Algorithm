def solution(n, k):
    answer = 0
    discount = int(n / 10)
  
    answer = (n * 12000) + ((k-discount) * 2000)
    return answer