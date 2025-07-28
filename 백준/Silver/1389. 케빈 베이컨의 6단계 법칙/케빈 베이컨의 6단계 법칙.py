from collections import deque

def bfs(start, graph, n):
    visited = [False] * (n + 1)
    distance = [0] * (n + 1)
    queue = deque([start])
    visited[start] = True

    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                distance[neighbor] = distance[current] + 1
                queue.append(neighbor)
    return sum(distance[1:])  # 0번 인덱스는 사용 안함

def main():
    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    min_sum = float('inf')
    answer = 0

    for i in range(1, n + 1):
        total = bfs(i, graph, n)
        if total < min_sum:
            min_sum = total
            answer = i

    print(answer)

if __name__ == "__main__":
    main()
