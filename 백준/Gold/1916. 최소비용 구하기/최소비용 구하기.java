import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int end, weight;
        public Node(int end, int weight){

            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int n,m;
    static ArrayList<Node>[] arr;
    static int MAX = 1_000_000_00;
    static int[] dist;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b,c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        dijkstra(start);
        System.out.println(dist[end]);

    }


    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new  int[n+1];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.weight > dist[cur.end]){continue;}
            for(Node next : arr[cur.end]){
                if(dist[next.end] > dist[cur.end] + next.weight){
                    dist[next.end] = dist[cur.end] + next.weight;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }
        }
    }


}
