import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static ArrayList<Node>[] arr;
    static int dist[];
    static int MAX = 9999999;

    static class Node implements Comparable<Node>{
        int end;
        int w;
        Node (int end, int w){
            this.end=end;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return Double.compare(w,o.w);
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=1;i<=m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,w));
        }

        int[][] real = new int[n+1][n+1];

        dist = new int[n+1];

        for(int i=1;i<=n;i++){
            dijkstra(i);
            for(int j=1;j<=n;j++){
                if(dist[j] == MAX) System.out.print(0+" ");
                else {
                    System.out.print(dist[j] + " ");
                }
            }
            System.out.println();
        }


    }


    public static void dijkstra(int start){

        dist = new int[n+1];
        for(int i=0;i<=n;i++){dist[i]=MAX;}

        dist[start] =0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for(Node next:arr[cur.end]){
                if(dist[next.end] >dist[cur.end]+next.w){
                    dist[next.end]=dist[cur.end]+next.w;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }

        }

    }

}
