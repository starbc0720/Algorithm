import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<MtRoom> meetings = new ArrayList<>(); //회의실 사용 갯수를 파악하기 위한 Queue 선언

    private static class MtRoom implements Comparable<MtRoom>{
        int start; //회의 시작 시간
        int end; //회의 종료 시간

        public MtRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MtRoom o) {
            if(this.end == o.end) return this.start - o.start; //회의가 끝나는 시간이 같으면, 시작 시간이 더 빠른 순으로 정렬 되게 설정
            return this.end - o.end; //회의 끝나는 시간 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //회의의 수
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new MtRoom(start,end));
        }

        Collections.sort(meetings); // 오름차순으로 정렬

        int cnt = 0;
        int prevEndTime = 0;

        for(MtRoom mt : meetings){
            if(mt.start >= prevEndTime){ //회의의 시작 시간이 이전 회의 종료 시간과 같거나 크면 회의 개수 추가
                cnt++;
                prevEndTime = mt.end;
            }
        }

        System.out.println(cnt);
    }

}