import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static int[] output;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];


        arr = new int[n];
        for(int i=1;i<=n;i++) arr[i-1] = i;
        output = new int[n];
        Permutation(n,m,0);

    }

    static void Permutation(int n,int m,int depth){
        if(depth == m){
            for (int i=0;i<m;i++) System.out.print(output[i]+" ");
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i] = true;
                output[depth] = arr[i];
                Permutation(n,m,depth+1);
                visit[i] = false;
            }
        }
    }

}