import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int end;
        int weight;
        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

    }

    static int n,p,k;
    static ArrayList<Node>[] arr;
    static ArrayList<Integer>max_list;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        max_list = new ArrayList<>();



        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= p; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[x].add(new Node(y,w));
            arr[y].add(new Node(x,w));

        }
        int ans=-1;
        int left = 0;
        int right = 1_000_000;
        while(left<=right){
            int mid = (left+right)/2;
            if(dijkstra(mid) <= k){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(ans==-1){
            System.out.println(-1);
        }else System.out.println(ans);
    }

    public static int dijkstra(int mid){
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.weight > dist[cur.end]) continue;

            for(Node next : arr[cur.end]){

                int cost = (next.weight>mid) ? 1:0;
                if(dist[next.end] > dist[cur.end] + cost){
                    dist[next.end] = dist[cur.end] + cost;
                    pq.offer(new Node(next.end,dist[next.end]));
                }
            }
        }

        return dist[n];

    }


}
