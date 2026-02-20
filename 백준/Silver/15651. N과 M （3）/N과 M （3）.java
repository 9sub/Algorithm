import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static int[] output;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];


        arr = new int[n];
        for(int i=1;i<=n;i++) arr[i-1] = i;
        output = new int[m];
        repeatPermutation(n,m,0);
        System.out.println(sb.toString());
    }

    static void repeatPermutation(int n, int m, int depth){
        if(depth==m){
            for(int i=0;i<m;i++){
                sb.append(output[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=0;i<n;i++){
            output[depth] = arr[i];
            repeatPermutation(n,m,depth+1);
        }
    }

}