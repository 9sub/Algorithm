import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n,m;
    static int[] arr;
    static  int[] output;
    static boolean[] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        output = new int[n];
        visit = new boolean[n];

        for(int i=1;i<=n;i++) arr[i-1] = i;

        permutation(0);

    }

    public static void permutation(int depth){
        if(depth == m){
            for(int i=0;i<m;i++) System.out.print(output[i] + " ");
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i] = true;
                output[depth] = arr[i];
                permutation(depth+1);
                visit[i] = false;
            }
        }
    }

}
