import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n,m,r;
    static ArrayList<Node>[] arr, rev;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int end, weight;
        Node (int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        arr = new ArrayList[n+1];
        rev = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            arr[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, 1));
            rev[b].add(new Node(a, 1));
        }

        int answer=0;
        for(int i=1;i<=n;i++) {
            int cnt1 = bfs(arr, i);
            int cnt2 = bfs(rev, i);
            if(cnt1+cnt2 == n-1) answer++;
        }
        System.out.println((answer));

    }

    static int bfs(ArrayList<Node>[] graph, int start){
        boolean [] visit = new boolean[n+1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,0));

        visit[start] = true;

        int cnt=0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node next : graph[cur.end]){
                if(!visit[next.end]){
                    visit[next.end] = true;
                    q.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
