import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken()); //M이상의 소수 구해야 함
        int N = Integer.parseInt(st.nextToken()); //N이하의 소수 구해야 함

        boolean[] isPrime = new boolean[N+1]; //1부터 표현해야 하므로 편의상 다음과 같이 +1 해줌

        //에라토스테네스의 체 알고리즘(통으로 외우면 편함)
        for(int i=2; i*i <= N; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<=N; j+=i){
                    isPrime[j] = true;
                }
            }
        }

        for(int i=M; i<=N; i++){
            if(i>1 &&  !isPrime[i]){ //1은 소수가 아니므로 1보다 커야함
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}