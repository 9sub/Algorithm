import java.util.*;

class Solution {
    
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static boolean[][] visit;
    
    static int n;
    static int m;
    
    static class Node{
        int i;
        int j;
        int dist;
        Node(int i, int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
        
        
        
    }
    
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        visit = new boolean [n][m];
        answer = bfs(maps);
        
        return answer;
    }
    
    public int bfs(int[][] maps){
        
        visit[0][0] = true;
        Queue<Node> que = new LinkedList();
        
        que.add(new Node(0,0,1));
        
        while(!que.isEmpty()){
            Node tmp = que.poll();
            int i = tmp.i;
            int j = tmp.j;
            int dist = tmp.dist;
            
            if(i == n-1 && j == m-1){
                return dist;
            }
            
            for(int d=0;d<4;d++){
                int nx = j+dx[d];
                int ny = i+dy[d];
                
                if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                
                if(!visit[ny][nx] && maps[ny][nx] == 1){
                    visit[ny][nx] = true;
                    
                    que.add(new Node(ny,nx,dist+1));
                }
                    
            }
            
        }
        
        return -1;
        
    }
    
    
}