
import java.util.*;

public class Main {

    static int n;
    static int k;
    static boolean[] visit;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        visit = new boolean[1111111];

        bfs(n);

    }

    public static void bfs(int start){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start,0});
        visit[start] = true;

        while(!que.isEmpty()){
            int[] tmp = que.poll();
            if(tmp[0] == k){
                System.out.println(tmp[1]);
                return;
            }
            for(int i=0;i<3;i++){
                int next;
                int time;

                if(i==0){ // *2
                    next = tmp[0] *2;
                    time = tmp[1];
                }
                else if (i==1){ // -1
                    next = tmp[0]-1;
                    time = tmp[1]+1;
                }
                else{ // 1
                    next = tmp[0]+1;
                    time = tmp[1]+1;
                }
                if(next>=0 && next<1111111 && !visit[next]){
                    que.add(new int[]{next, time});
                    visit[next] = true;
                }

            }
        }


    }


}