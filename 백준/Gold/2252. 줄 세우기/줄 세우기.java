import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        result = new ArrayList<>();
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        indegree = new int[n+1];


        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        sort();
        for(int i=0;i<n;i++){
            System.out.printf("%d ",result.get(i));
        }

    }


    public static void sort(){
        Queue<Integer> que = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int cur = que.poll();
            result.add(cur);
            for(int next:graph[cur]){
                indegree[next]--;
                if(indegree[next] == 0){
                    que.offer(next);
                }
            }
        }

    }


}