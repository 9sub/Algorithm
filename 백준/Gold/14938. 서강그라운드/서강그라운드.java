import java.io.*;
import java.util.*;

public class Main {

    static int n,m,r;
    static int[] weight, dist;
    static ArrayList<Node>[] arr;

    static class Node implements Comparable<Node>{
        int end, dist;
        Node(int end, int dist){
            this.end = end;
            this.dist = dist;

        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        weight = new int[n+1];
        dist = new int[n+1];

        arr = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=r;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        int answer = 0;

        for(int i=1;i<=n;i++) {

            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);


    }

    static int find(){
        int sum=0;
        for(int i = 1; i <= n; i++){
            if(dist[i]<=m){
                sum+= weight[i];
            }
        }
        return sum;
    }

    static int dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.dist > dist[cur.end]) continue;

            for(Node next : arr[cur.end]){
                if(dist[next.end] > dist[cur.end] + next.dist){
                    dist[next.end] = dist[cur.end] + next.dist;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }


        return find();
    }


}