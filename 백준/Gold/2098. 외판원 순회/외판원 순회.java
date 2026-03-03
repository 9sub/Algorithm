import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int arange; // 비트 마스크로 표현했을때 가질 수 있는 최대 값 2^n-1
    static int[][] w;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        w = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arange = (int)Math.pow(2, n-1);
        dist = new int[n][arange];

        for(int i = 0; i < n; i++){
            for(int j=0; j<arange; j++){
                dist[i][j] = -1;
            }
        }

        dist[0][0] = 0;
        for(int i=1;i<n;i++){
            if(w[i][0] == 0) dist[i][0] = Integer.MAX_VALUE;
            else dist[i][0] = w[i][0];
        }
        System.out.println(tsp(0,arange-1));

    }

    public static int tsp(int i, int a){
        if(dist[i][a] != -1) return dist[i][a];

        int min = Integer.MAX_VALUE;
        for(int j=1;j<n;++j){
            if((a & 1 << (j-1)) == 0 ) continue;

            int prev = tsp(j, a & ~(1 << (j-1)));
            if(prev == Integer.MAX_VALUE || w[i][j] == 0) continue;
            min = Math.min(min, w[i][j]+prev);
        }
        return dist[i][a]  = min;
    }

}