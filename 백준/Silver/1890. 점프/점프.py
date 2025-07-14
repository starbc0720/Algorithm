import sys
input = sys.stdin.readline

def main():
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    
    # dp[i][j] := (0,0)에서 (i,j)까지 올 수 있는 경로의 수
    dp = [[0]*N for _ in range(N)]
    dp[0][0] = 1  # 출발점
    
    for i in range(N):
        for j in range(N):
            if dp[i][j] == 0:
                continue  # 이 칸에 올 수 있는 경로가 하나도 없으면 건너뜀
            jump = board[i][j]
            if jump == 0:
                continue  # 마지막 칸(혹은 0인 칸)은 더 이상 못 감
            
            # 오른쪽으로 jump 칸
            nj = j + jump
            if nj < N:
                dp[i][nj] += dp[i][j]
            
            # 아래로 jump 칸
            ni = i + jump
            if ni < N:
                dp[ni][j] += dp[i][j]
    
    # (N-1, N-1) 칸에 도달하는 경로의 수
    print(dp[N-1][N-1])

if __name__ == "__main__":
    main()