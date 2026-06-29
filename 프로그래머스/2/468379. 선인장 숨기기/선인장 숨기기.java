import java.util.*;

class Solution {
    static int ans_x = 0;
    static int ans_y = 0;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static int max=0;
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int INF = 1_000_000_000;
        int[][] arr = new int[m][n];
        
        for(int i=0;i<drops.length;i++){
            arr[drops[i][0]][drops[i][1]] = i+1;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] ==0) arr[i][j] = INF;
            }
        }
        
        int[][] rowMin = new int[m][n-w+1];
        for(int y = 0;y<m;y++){
            Deque<Integer> que = new ArrayDeque<>();
            for(int x=0;x<n;x++){
                while(!que.isEmpty() && arr[y][que.peekLast()] >= arr[y][x]){
                    que.pollLast();
                }
                
                que.offerLast(x);
                
                if(que.peekFirst()<=x-w) que.pollFirst();
                if(x>=w-1){
                    int start_x = x-w+1;
                    rowMin[y][start_x] = arr[y][que.peekFirst()];
                }
                
            }
        }
        
        int[][] rectMin = new int[m - h + 1][n - w + 1];
        for (int x = 0; x <= n - w; x++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int y = 0; y < m; y++) {
                while (!dq.isEmpty() && rowMin[dq.peekLast()][x] >= rowMin[y][x]) {
                    dq.pollLast();
                }
                dq.offerLast(y);
                if (dq.peekFirst() <= y - h) {
                    dq.pollFirst();
                }
                if (y >= h - 1) {
                    int startY = y - h + 1;
                    rectMin[startY][x] = rowMin[dq.peekFirst()][x];
                }
            }
        }
        int ansY = 0;

        int ansX = 0;

        int best = -1;

        for (int y = 0; y <= m - h; y++) {

            for (int x = 0; x <= n - w; x++) {

                if (rectMin[y][x] > best) {

                    best = rectMin[y][x];

                    ansY = y;

                    ansX = x;

                }

            }

        }

        return new int[]{ansY, ansX};
    }       
}