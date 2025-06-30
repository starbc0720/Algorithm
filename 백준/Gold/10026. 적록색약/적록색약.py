import sys
sys.setrecursionlimit(10000) # 재귀 호출 깊이 제한 설정 코드(default = 1000)

def main():
    n = int(sys.stdin.readline())
    graph = [list(sys.stdin.readline().strip()) for _ in range(n)]

    visited = [[False]*n for _ in range(n)] #방문여부 체크

    # 상, 하, 좌, 우 방향
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # DFS 정의
    def dfs(x, y, color):
        visited[x][y] = True
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if not visited[nx][ny] and graph[nx][ny] == color:
                    dfs(nx, ny, color)

    # 적록색약 아닌 사람 기준 구역 수 세기
    normal_count = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                dfs(i, j, graph[i][j])
                normal_count += 1

    # 적록색약인 사람 시야로 그래프 변형 (G → R)
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 'G':
                graph[i][j] = 'R'

    # 방문 배열 초기화 후 다시 DFS
    visited = [[False]*n for _ in range(n)]
    color_weak_count = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                dfs(i, j, graph[i][j])
                color_weak_count += 1

    print(normal_count, color_weak_count)


if __name__ == "__main__":
    main()