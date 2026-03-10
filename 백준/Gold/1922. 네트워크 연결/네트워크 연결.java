import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n,m,k;
    static ArrayList<Node>[] arr;

    static class Node implements Comparable<Node> {
        int end;
        int w;
        Node(int end,int w){
            this.end=end;
            this.w=w;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.w,o.w);
        }

    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        prim();
    }


    public static void prim(){
        boolean[] visit = new boolean[n+1];
        Arrays.fill(visit, false);

        PriorityQueue<Node> que = new PriorityQueue<>();

        int cnt=0;
        int ans = 0;

        que.add(new Node(1,0));
        while(!que.isEmpty()){
            Node cur = que.poll();

            if(visit[cur.end]){
                continue;
            }

            visit[cur.end] = true;
            ans += cur.w;
            cnt++;

            if(cnt == n) break;

            for(Node next : arr[cur.end]){
                if(!visit[next.end]){
                    que.add(next);
                }
            }

        }
        System.out.println(ans);

    }


}
