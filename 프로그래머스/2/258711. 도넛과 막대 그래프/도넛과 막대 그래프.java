import java.util.*;


class Solution {
    
    static int[] in;
    static int[] out;

    
    public int[] solution(int[][] edges) {
        int n=0;
        int[] answer={};
        int[] visit;
        
        for(int[] edge : edges){
            n = Math.max(n,Math.max(edge[0], edge[1]));
        }
        in = new int[n+1];
        out = new int[n+1];
        visit = new int[n+1];
        answer = new int[4];
        for(int i=0;i<edges.length;i++){
            out[edges[i][0]]++;
            in[edges[i][1]]++;
            visit[edges[i][0]] = 1;
            visit[edges[i][1]] = 1;
        }

        for(int i=1;i<n+1;i++){
            if(in[i] == 0 && out[i]>=2 && visit[i] != 0){ //시작 정점
                answer[0] = i;
            }
        }
        
        for(int i=1;i<n+1;i++){
            if(out[i] == 0 && i != answer[0] && visit[i] != 0){// 막대 모양 그래프 => 시작정점이 아니고, out이 0
                answer[2]++;
            }else if(out[i] == 2 && i != answer[0] && visit[i] != 0){ // 8자 모양 그래프=> 정점 아니고, out 2
                answer[3]++;
            }
        }
        
        answer[1] = out[answer[0]] - answer[2] - answer[3];// 나머지 도넛
        
        
        return answer;
    }
}