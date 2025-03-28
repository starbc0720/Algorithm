import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] box;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1}; // 상하좌우 방향
    static int[] dy = {1, -1, 0, 0};
    static int days = 0;

    static class Point {
        int x;
        int y;
        int day;

        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new Point(i, j, 0)); // 익은 토마토 위치 큐에 추가
                }
            }
        }

        bfs();

        if (checkUnripe()) {
            System.out.println(-1); // 안 익은 토마토가 있으면 -1 출력
        } else {
            System.out.println(days); // 최소 날짜 출력
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            int day = p.day;
            days = day; // 최대 날짜 갱신

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = 1; // 토마토 익히기
                    queue.add(new Point(nx, ny, day + 1));
                }
            }
        }
    }

    static boolean checkUnripe() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return true; // 안 익은 토마토가 있으면 true 반환
                }
            }
        }
        return false; // 모두 익었으면 false 반환
    }
}