public class Main {

    // 생성자 함수 d(n)
    private static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean[] selfNumbers = new boolean[10001]; // 셀프 넘버 여부를 저장하는 배열
        for (int i = 1; i <= 10000; i++) {
            selfNumbers[i] = true; // 모든 수를 셀프 넘버로 초기화
        }

        for (int i = 1; i <= 10000; i++) {
            int dn = d(i); // i의 생성자 계산
            if (dn <= 10000) {
                selfNumbers[dn] = false; // 생성자가 있는 수는 셀프 넘버가 아님
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (selfNumbers[i]) {
                sb.append(i).append("\n"); // 셀프 넘버를 StringBuilder에 추가
            }
        }

        System.out.print(sb);
    }
}