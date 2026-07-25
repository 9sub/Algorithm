import java.util.*;

class Solution {
    
    static boolean[][] visit;
    
    static List<Integer> arr = new ArrayList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    
    public int[] solution(String[] maps) {
        int[] answer;
        visit = new boolean[maps.length][maps[0].length()];
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(!visit[i][j] && maps[i].charAt(j) !='X'){
                    arr.add(bfs(maps, i, j));
                }
            }
        }
        if(arr.size() == 0) return new int[]{-1};
        Collections.sort(arr);
        answer= new int[arr.size()];
        for(int i=0;i<arr.size();i++)answer[i] = arr.get(i);
        
        return answer;
    }
    
    public int bfs(String[] maps, int i, int j){
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        visit[i][j] = true;
        int cnt=0;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            cnt += maps[cur[0]].charAt(cur[1])-'0';
            for(int d=0;d<4;d++){
                int nx = cur[1]+dx[d];
                int ny = cur[0]+dy[d];
                if(nx<0 || nx>=maps[0].length() || ny<0 || ny>=maps.length) continue;
                if(maps[ny].charAt(nx) != 'X' && !visit[ny][nx]){
                    visit[ny][nx] = true;
                    que.add(new int[]{ny, nx});
                }
            }
        }
        return cnt;
    }
    
}