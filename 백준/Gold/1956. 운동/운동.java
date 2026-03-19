import java.io.*;
import java.util.*;

public class Main {

    static int v,e;
    static int[][] arr;
    static int MAX = 1_000_000_000;



    public static void main(String[] args) throws Exception {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        arr = new int[v+1][v+1];

        for(int i = 1; i <= v; i++){
            Arrays.fill(arr[i],MAX);
            arr[i][i] = 0;
        }
        
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }

        for(int k=1;k<=v;k++){
            for(int i=1;i<=v;i++){
                for(int j=1;j<=v;j++){
                    if(arr[i][k] == MAX || arr[k][j] == MAX) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int answer = MAX;
        for(int i=1;i<=v;i++){
            for(int j=1;j<=v;j++){
                if(i==j) continue;
                if(arr[i][j] == MAX || arr[i][j]==MAX) continue;
                answer = Math.min(answer, arr[i][j]+arr[j][i]);
            }
        }
        System.out.println(answer == MAX ? -1 : answer);


    }


}
