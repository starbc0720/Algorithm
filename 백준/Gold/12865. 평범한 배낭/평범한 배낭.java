import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //물품의 수
        int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게

        int[] weight = new int[N+1]; // 물품의 수 만큼 무게 존재
        int[] val = new int[N+1]; // 물품의 수 만큼 가치 존재
        int[][] dp = new int[N+1][K+1]; //DP(동적 계획법), 점화식으로 풀기 위해 다음과 같이 선언

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            weight[i] = Integer.parseInt(st.nextToken());
            val[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int w=1; w<=K; w++){
                if(weight[i] <= w){ // 현재 물품의 무게보다 배낭이 감당 가능한 무게가 더 크거나 같을 떄 담을 수 있음
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]] + val[i]); //dp[i-1][w-weight[i]]는 "i번째 물건을 넣기 전에, 남은 무게를 가지고 얻을 수 있는 최대 가치"를 의미
                } else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
