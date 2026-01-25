
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        dist = new int[n][m];
        dist[0][0] =1;

        for(int i=0;i<n;i++){
            String line = sc.next();
            for(int j=0;j<m;j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(dist[n-1][m-1]);
    }


    public static  void bfs(int x,int y){
        Queue<int[] > que = new LinkedList<>();
        que.add(new int[]{x,y});

        while(!que.isEmpty()){
            int[] tmp = que.poll();
            int cx = tmp[0];
            int cy = tmp[1];

            for(int d = 0;d<4;d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(arr[nx][ny] != 0){
                        if(dist[nx][ny]==0){
                            dist[nx][ny] = dist[cx][cy]+1;
                            que.add(new int[]{nx,ny});
                        }
                    }
                }

            }

        }

    }

}