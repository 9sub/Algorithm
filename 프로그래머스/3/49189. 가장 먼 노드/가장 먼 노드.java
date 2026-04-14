import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int next;
        int w;
        Node(int next, int w){
            this.next = next;
            this.w = w;
            
        }
        
        @Override
        public int compareTo(Node o){
            return o.w-this.w;
        }
        
        
    }
    
    static ArrayList<Node>[] arr;
    static int[] dist;
    static int max_val = 1_000_000_000;
    
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++) arr[i] = new ArrayList<>();
        
        dist = new int[n+1];
        Arrays.fill(dist, max_val);
        
        for(int[] tmp : edge){
            arr[tmp[0]].add(new Node(tmp[1], 1));
            arr[tmp[1]].add(new Node(tmp[0],1));
        }
        
        dijkstra();

        
        int max=0;
        
        for(int i=1;i<=n;i++){
            if(dist[i] == max_val) continue;
            max = Math.max(max, dist[i]);
        }
        
        for(int i=1;i<=n;i++){
            if(dist[i] == max) answer++;
        }
        
        
        return answer;
    }
    
    public static void dijkstra(){        
        PriorityQueue<Node> que =new PriorityQueue<>();
        que.add(new Node(1,0));
        dist[1] = 0;
        
        while(!que.isEmpty()){
            Node cur = que.poll();
            
            for(Node next : arr[cur.next]){
                if(dist[next.next] > dist[cur.next] + next.w){
                    dist[next.next] = dist[cur.next] + next.w;
                    que.add(new Node(next.next, dist[next.next]));
                }
            }
            
        }
        
    }
    
}