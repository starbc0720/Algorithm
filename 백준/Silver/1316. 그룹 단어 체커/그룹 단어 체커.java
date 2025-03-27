import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean chekGrpStr(String str){
        String res = "";
        boolean flag = true;

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i-1) != str.charAt(i)){
                if(res.contains(String.valueOf(str.charAt(i)))){
                    flag = false;
                    break;
                }
            }

            res += str.charAt(i-1);
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt=0; // 그룹 단어 개수 파악용
        for(int i=0; i<N; i++){
            String input = br.readLine();

            if(chekGrpStr(input)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}