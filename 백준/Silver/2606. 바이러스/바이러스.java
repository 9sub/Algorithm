
import java.util.*;

public class Main {

    static int computer;
    static int n;
    static List<Integer>[] graph;
    static boolean[] visit;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        computer = sc.nextInt();
        n = sc.nextInt();

        graph = new ArrayList[computer+1];
        for(int i=0;i<=computer;i++) graph[i] = new ArrayList<>();

        visit = new boolean[computer+1];

        for(int i=1;i<=n;i++){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();

            graph[t1].add(t2);
            graph[t2].add(t1);
        }

        dfs(1);
        System.out.println(cnt);

    }


    public static void dfs(int start){
        visit[start] = true;
        for(int next: graph[start]){
            if(!visit[next]) {
                dfs(next);
                cnt+=1;
            }
        }
    }

}