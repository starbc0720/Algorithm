import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); //M이상인 값
        int N = Integer.parseInt(st.nextToken()); //N이하인 값

        boolean[] isPrime = new boolean[N+1]; //소수임을 판단하기 위한 변수 선언

        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    if (j < isPrime.length) { // 배열 범위 확인
                        isPrime[j] = true; // i의 배수는 소수가 아님
                    }
                }
            }
        }

        for(int i=M; i<=N; i++){
            if(i>1 && !isPrime[i]){
                System.out.println(i);
            }
        }
    }
}