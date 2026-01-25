
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int v;
    static boolean[] visit ;


    static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        graph = new ArrayList[n+1];

        for(int i=1;i<=n;i++) graph[i] = new ArrayList<>();


        // make graph
        for(int i=0;i<m;i++){
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();

            graph[tmp1].add(tmp2);
            graph[tmp2].add(tmp1);
        }

        for(int i=1;i<=n;i++) Collections.sort(graph[i]);

        visit = new boolean[n+1];

        dfs(v);
        System.out.println();
        bfs(v);


    }

    public static void dfs(int start){
        visit[start] = true;
        System.out.print(start+" ");

        for(int next: graph[start]){
            if(!visit[next]) dfs(next);
        }

    }


    public static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[n+1];

        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()){
            int tmp = que.poll();
            System.out.print(tmp+" ");

            for(int next:graph[tmp]){
                if(!visit[next]){
                    visit[next] = true;
                    que.add(next);
                }
            }
        }

    }


}