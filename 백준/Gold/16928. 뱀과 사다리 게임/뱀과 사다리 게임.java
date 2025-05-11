import java.io.*;
import java.util.*;

public class Main {
    static int[] move = new int[101]; // 각 칸의 최종 도착 위치
    static boolean[] visited = new boolean[101]; // 방문 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀 수

        // 초기화: 아무 이동도 없으면 자기 자신으로
        for (int i = 1; i <= 100; i++) {
            move[i] = i;
        }

        // 사다리 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            move[from] = to;
        }

        // 뱀 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            move[from] = to;
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // 시작 위치: 1번칸, 이동 횟수 0
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int position = curr[0];
            int count = curr[1];

            if (position == 100) return count;

            for (int dice = 1; dice <= 6; dice++) {
                int next = position + dice;
                if (next > 100) continue;

                int finalPos = move[next];
                if (!visited[finalPos]) {
                    visited[finalPos] = true;
                    queue.offer(new int[]{finalPos, count + 1});
                }
            }
        }

        return -1; // 도달 못할 경우 (문제 조건상 없지만 안전망)
    }
}
