from itertools import combinations
import sys

input = sys.stdin.read
data = input().strip().split('\n')

result = []

for line in data:
    if line == "0":
        break
    parts = list(map(int, line.strip().split()))
    k, S = parts[0], parts[1:]
    combos = list(combinations(S, 6))
    output = [' '.join(map(str, combo)) for combo in combos]
    result.append('\n'.join(output))

# 출력
print('\n\n'.join(result))
