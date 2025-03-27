import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 한 수를 계산하는 로직
    private static boolean checkAS(int n){
        boolean result = true;
        if(n < 100){
            return true;
        }

        String val = Integer.toString(n);
        int checkNum = 0;
        for(int i=1; i<val.length(); i++){
            if(i==1){
                checkNum = val.charAt(i) - val.charAt(i-1);
            } else{
                int tmpCheckNum = val.charAt(i) - val.charAt(i-1);
                if(checkNum != tmpCheckNum){
                    result = false;
                    break;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0; //N까지의 등차수열의 개수를 카운트 하기 위한 변수

        for(int i=1; i<=N; i++){
            if(checkAS(i)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}