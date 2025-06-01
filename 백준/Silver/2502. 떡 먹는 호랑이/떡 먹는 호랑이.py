import sys

D, K = map(int, sys.stdin.readline().split())

# 피보나치 계수 초기화
fibA = [0] * (D + 1)
fibB = [0] * (D + 1)

fibA[1], fibA[2] = 1, 0
fibB[1], fibB[2] = 0, 1

# 피보나치 계수 계산
for i in range(3, D + 1):
    fibA[i] = fibA[i - 1] + fibA[i - 2]
    fibB[i] = fibB[i - 1] + fibB[i - 2]

# 정답 탐색
for A in range(1, K):
    rest = K - fibA[D] * A
    if rest % fibB[D] != 0:
        continue
    B = rest // fibB[D]
    if A <= B:
        print(A)
        print(B)
        break