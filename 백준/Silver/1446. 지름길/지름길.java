import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,d;
    static int[] dist;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node>{
        int end;
        int cost;
        Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

    }

    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.offer(new Node(0,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost > dist[cur.end]) continue;

            for(Node next : graph[cur.end]){
                if(dist[next.end] > dist[cur.end] + next.cost){
                    dist[next.end] = dist[cur.end] + next.cost;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        dist = new int[d+1];
        Arrays.fill(dist, Integer.MAX_VALUE);


        graph = new ArrayList[d+1];
        for(int i=0;i<=d;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<d;i++) graph[i].add(new Node(i+1,1));

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c =  Integer.parseInt(st.nextToken());

            if(a >d || b>d) continue;

            graph[a].add(new Node(b, c));
        }

        dijkstra();
//        System.out.println(Arrays.toString(dist));
        System.out.println(dist[d]);


    }
}