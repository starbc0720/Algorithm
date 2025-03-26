public class Main {

    //생성자 여부 판단하는 함수
    private static int checkConst(int n){
        int sum = n;
        while(n > 0){
            sum += n % 10; //n의 가장 오른쪽 자리수를 sum에 더함, n의 마지막 자리수 획득 및 sum에 더함
            n /= 10; //n의 가장 오른쪽 자리수 제거
        }

        return sum;
    }

    public static void main(String[] args) {
        boolean[] selfNums = new boolean[10001];
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=10000; i++){
            int d = checkConst(i);
            if(d <= 10000){
                selfNums[d] = true;
            }
        }

        for(int i=1; i<=10000 ; i++){
            if(!selfNums[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
