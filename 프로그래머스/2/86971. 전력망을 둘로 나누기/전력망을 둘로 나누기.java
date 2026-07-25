import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] arr;
    
    public int solution(int n, int[][] wires) {
        int answer = 1_000_000_000;
        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<>();
        }

        
        for(int i=0;i<wires.length;i++){
            int[] tmp = wires[i];
            arr[tmp[0]].add(tmp[1]);
            arr[tmp[1]].add(tmp[0]);
        }
        
        for(int i=0;i<wires.length;i++){
            int a= wires[i][0];
            int b = wires[i][1];
            
            boolean[] visit = new boolean[n+1];
            
            arr[a].remove(Integer.valueOf(b));
            arr[b].remove(Integer.valueOf(a));
            
            int cnt1 = bfs(visit,a);
            int cnt2 = bfs(visit,b);
            
            answer = Math.min(answer, Math.abs(cnt1-cnt2));
            
            arr[a].add(b);
            arr[b].add(a);
        }
        
        return answer;
    }
    
    public static int bfs(boolean[] visit, int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;
        int cnt=0;
        while(!que.isEmpty()){
            int tmp = que.poll();
            cnt++;
            for(int t:arr[tmp]){
                if(!visit[t]){
                    que.add(t);
                    visit[t] = true;
                }
            }
        }
        return cnt;
    }
    
}