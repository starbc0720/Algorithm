import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] box; //토마토를 담을 상자의 크기
    //토마토 익는 게 상하좌우로 움직일 수 있음
    private static int[] mx = {0, 0, -1, 1}; //mx에서는 좌우 움직임 표현
    private static int[] my = {-1, 1, 0, 0}; //my에서는 상하 움직임 표현
    private static Queue<Point> queue = new LinkedList<>(); // 토마토 익는 것, 너비 탐색을 위한 큐 선언
    private static int M, N; //M : 상자 가로 칸의 수, N : 상자 세로 칸의 수
    private static int days = 0; //토마토가 익는 데 걸리는 시간

    private static class Point{ //토마토 위치와 익은 날짜를 저장하기 위한 클래스 선언
        int x;
        int y;
        int day;

        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    private static void bfs(){
        while(!queue.isEmpty()){
            Point tomato = queue.poll();
            int tx = tomato.x; //토마토의 x좌표
            int ty = tomato.y; //토마토의 y좌표
            int td = tomato.day; //토마토의 익는 데 걸리는 날짜
            days = td; // 익는 데 걸리는 시간 갱신

            for(int i=0; i<4; i++){ //상하좌우로 확인해야 하므로 다음과 같이 선언
                int tmx = tx + mx[i]; //좌우 계산
                int tmy = ty + my[i]; //상하 계산

                if(tmx >= 0 && tmx < N && tmy >= 0 && tmy < M && box[tmx][tmy] == 0){
                    box[tmx][tmy] = 1; //익음 처리
                    queue.add(new Point(tmx, tmy, td+1));
                }
            }
       }
    }

    private static boolean checkRipe(){ //익었는 지 안익었는지 확인하는 함수
        for(int i=0; i<N; i++){ //상자 세로 칸 수 만큼 반복
            for(int j=0; j<M; j++){ //상자 가로 칸 수 만큼 반복
                if(box[i][j] == 0){
                    return false;
                }
           }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); //상자 세로 칸의 수
        box = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.add(new Point(i, j, 0));
                }
            }
        }

        bfs(); //bfs 탐색을 통해 익는 거 확인

        if(checkRipe()){
            System.out.println(days); //익었으면 걸린 날짜 표현
        } else {
            System.out.println(-1); //다 못익었으면 -1로 표현
        }
    }
}