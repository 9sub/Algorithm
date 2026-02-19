import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v,e,k;
    static int[] dist;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node>{
        int next;
        int weight;

        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.weight, o.weight);
        }

    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        for(int i=1;i<=v;i++){
            graph[i] = new ArrayList<>();
        }
        dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }

        dijkstra();

        for(int i=1;i<=v;i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }


    }

    public static void dijkstra(){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k,0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            Node cur =pq.poll();

            for(Node next : graph[cur.next]){
                if(dist[next.next] > dist[cur.next] + next.weight){
                    dist[next.next] = dist[cur.next] + next.weight;
                    pq.offer(new Node(next.next, dist[next.next]));
                }
            }

        }


    }


}