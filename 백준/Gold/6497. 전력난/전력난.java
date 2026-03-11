import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Node>[] arr;
    static class Node implements Comparable<Node> {
        int next;
        int dist;
        Node(int n, int d){
            this.next = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if(m==0 && n==0) break;
            arr = new ArrayList[m];
            for (int i = 0; i < m; i++) arr[i] = new ArrayList<>();

            int total =0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                arr[x].add(new Node(y, z));
                arr[y].add(new Node(x, z));
                total+=z;
            }

            int tmp = prim(0);
            System.out.println(total - tmp);
        }
    }

    public static int prim(int start){
        boolean[] visit =  new boolean[m];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));


        int sum=0;

        while(!pq.isEmpty()){
            Node next = pq.poll();

            if(visit[next.next]) continue;
            visit[next.next] = true;
            sum+= next.dist;

            for(Node n: arr[next.next]){
                pq.offer(n);
            }

        }

        return sum;
    }


}
