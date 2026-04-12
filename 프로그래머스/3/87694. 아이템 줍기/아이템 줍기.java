import java.util.*;

class Solution {
    
    static int[][] arr;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        arr = new int[101][101];
        
        for(int[] rec : rectangle){
            
            rec[0] *=2;
            rec[1] *=2;
            rec[2] *=2;
            rec[3] *= 2;
            
            for(int i=rec[1];i<=rec[3];i++){
                for(int j=rec[0];j<=rec[2];j++){
                    if(i==rec[1] || i== rec[3] || j== rec[0]||j==rec[2]){
                        if(arr[i][j] == -1) continue;
                        arr[i][j] = 1;
                    }else{
                        arr[i][j] = -1;
                    }
                }
            }
        }
        return (bfs(characterX*2, characterY*2, itemX*2, itemY*2));
        
    }
    
    public int bfs(int x, int y, int itemx, int itemy){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{y,x, 0});
        
        boolean[][] visit = new boolean[101][101];
        visit[y][x] = true;
        
        while(!que.isEmpty()){
            int[] tmp = que.poll();
            int tmp_y = tmp[0];
            int tmp_x = tmp[1];
            
            if(tmp_y == itemy && tmp_x==itemx) return tmp[2]/2;
            
            for(int d=0;d<4;d++){
                int nx = tmp_x + dx[d];
                int ny = tmp_y + dy[d];
                if(nx<0 || nx>=101 || ny<0 || ny>=101) continue;
                if(!visit[ny][nx] && arr[ny][nx] == 1){
                    visit[ny][nx] = true;
                    que.offer(new int[]{ny, nx, tmp[2]+1});
                }
            }
        }
        return -1;
    }
    
}