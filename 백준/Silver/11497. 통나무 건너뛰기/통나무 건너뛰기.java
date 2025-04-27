import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] logs = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                logs[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(logs);

            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    deque.addFirst(logs[i]);
                } else {
                    deque.addLast(logs[i]);
                }
            }

            int maxDiff = 0;
            Integer[] arranged = deque.toArray(new Integer[0]);

            for (int i = 0; i < N; i++) {
                int diff = Math.abs(arranged[i] - arranged[(i + 1) % N]);
                maxDiff = Math.max(maxDiff, diff);
            }

            sb.append(maxDiff).append('\n');
        }

        System.out.print(sb);
    }
}
