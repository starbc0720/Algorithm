import sys
input = sys.stdin.readline
MOD = 10**9

def main():
    N, K = map(int, input().split())
    # dp[i][j] = i개의 수를 더해서 합이 j가 되는 경우의 수
    dp = [ [0]*(N+1) for _ in range(K+1) ]
    
    # i=1: 한 수로 만들 수 있는 합 j는 (x=j 하나 뿐) → 1
    for j in range(N+1):
        dp[1][j] = 1
    
    # i=2..K
    for i in range(2, K+1):
        # 누적합 cum[j] = dp[i-1][0] + dp[i-1][1] + ... + dp[i-1][j]
        cum = 0
        for j in range(N+1):
            cum = (cum + dp[i-1][j]) % MOD
            # dp[i][j] = sum_{x=0..j} dp[i-1][j-x]  ← 이게 누적합으로 cum[j]
            dp[i][j] = cum
    
    # 정답: K개의 수를 더해서 N이 되는 경우의 수
    print(dp[K][N] % MOD)

if __name__ == "__main__":
    main()