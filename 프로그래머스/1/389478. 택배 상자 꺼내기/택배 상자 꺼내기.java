class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int row = (num - 1) / w;
        int col;
        
        // 해당 상자의 열 계산
        if(row % 2 == 0){
            col = (num - 1) % w; // 왼 -> 오
        } else {
            col = w - 1 - (num - 1) % w; // 오 -> 왼
        }
        
        answer = 1; // 자기 자신 포함
        for(int r = row + 1; r <= (n-1) / w; r++){
            int index;
            if (r % 2 == 0){
                index = r * w + col;
            } else {
                index = r * w + (w -1 - col);
            }
            
            if(index < n){
                answer++;
            }
        }
        
        return answer;
    }
}