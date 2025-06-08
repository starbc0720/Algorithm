import sys

N = int(sys.stdin.readline())
expr = sys.stdin.readline().strip()

values = [int(sys.stdin.readline()) for _ in range(N)]
stack = []

for ch in expr:
    if 'A' <= ch <= 'Z':
        stack.append(values[ord(ch) - ord('A')])
    else:
        b = stack.pop()
        a = stack.pop()
        if ch == '+':
            stack.append(a + b)
        elif ch == '-':
            stack.append(a - b)
        elif ch == '*':
            stack.append(a * b)
        elif ch == '/':
            stack.append(a / b)

print(f"{stack[0]:.2f}")
