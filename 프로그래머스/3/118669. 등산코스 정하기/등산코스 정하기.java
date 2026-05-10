import java.util.*;

class Solution {
    static ArrayList<Node>[] arr;
    static int[] dist;
    static boolean[] is_gate;
    static boolean[] is_top;
    
    static class Node implements Comparable<Node>{
        int next;
        int weight;
        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o){
            return this.weight-o.weight;
        }
        
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        
        arr = new ArrayList[n+1];
        is_top = new boolean[n+1];
        is_gate = new boolean[n+1];
        
        for(int i=0;i<n+1;i++){
            arr[i] = new ArrayList<>();
        }
        for(int[] path:paths){
            arr[path[0]].add(new Node(path[1], path[2]));
            arr[path[1]].add(new Node(path[0], path[2]));
        }
        
        for(int gate:gates) is_gate[gate] = true;
        
        for(int summit:summits) is_top[summit] = true;
        
        dijkstra(n, gates);
        
        Arrays.sort(summits); // inten이 최소가 되는 등산 코스가 여러개일 경우 작은 번호로
        
        int ans_top=0;
        int ans_w=1_000_000_000;
        for(int summit:summits){
            if(dist[summit]<ans_w){
                ans_w = dist[summit];
                ans_top = summit;
            }
        }
        
        return new int[]{ans_top, ans_w};
    }
    
    public static void dijkstra(int n, int[] gates){
        
        // 여러 경로중 inten이 최소인 경로 찾기
        // inten은 경로중 최대
        
        dist = new int[n+1];
        Arrays.fill(dist, 1_000_000_000);
        
        PriorityQueue<Node> que = new PriorityQueue<>();
        
        for(int gate: gates){
            dist[gate] = 0;
            que.add(new Node(gate,0));
        }
        
        while(!que.isEmpty()){
            Node cur = que.poll();
            
            int now = cur.next;
            int now_inten = cur.weight;
            
            if (now_inten > dist[now]) continue; // 옛날 노드 패스
            
            if(is_top[now]) continue; // 정상이면 진행 안함
            
            for(Node next: arr[now]){
                
                int next_node = next.next;
                int w= next.weight;
                
                if(is_gate[next_node]) continue;//게이트로 돌아오는거 방지
                
                int next_inten = Math.max(now_inten, w);
                
                if(next_inten < dist[next_node]){
                    dist[next_node] = next_inten;
                    que.offer(new Node(next_node, next_inten));
                }
            }
            
        }
        
        
    }
    
}