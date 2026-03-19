import java.io.*;
import java.util.*;

public class Main {

    static int n,e;
    static ArrayList<Node>[] arr;
    static int v1, v2;
    static int[] dist;
    static int MAX = 9999999;

    static class Node implements Comparable<Node> {
        int end, weight;
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;

        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }


    public static void main(String[] args) throws Exception {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(st.nextToken());
       e = Integer.parseInt(st.nextToken());

       arr = new ArrayList[n+1];
       for(int i = 1;i<=n;i++)
           arr[i] = new ArrayList<>();


       for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
       }

       st = new StringTokenizer(br.readLine());
       v1 = Integer.parseInt(st.nextToken());
       v2 = Integer.parseInt(st.nextToken());

        int sum=0;
        dijkstra(1);
        sum+= dist[v1];
        dijkstra(v1);
        sum+= dist[v2];
        dijkstra(v2);
        sum+= dist[n];

        int sum2=0;
        dijkstra(1);
        sum2+= dist[v2];
        dijkstra(v2);
        sum2+= dist[v1];
        dijkstra(v1);
        sum2+= dist[n];


        sum = Math.min(sum, sum2);


        if(sum>=MAX) System.out.println(-1);
        else System.out.println(sum);


    }


    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist =new int[n+1];
        for(int i=0;i<=n;i++) dist[i] = MAX;
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for(Node next : arr[cur.end] ){
                if(dist[next.end] > dist[cur.end] + next.weight){
                    dist[next.end] = dist[cur.end] + next.weight;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }

    }


}
