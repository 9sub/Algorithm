import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n,m;
    static int[] arr;
    static int[] output;
    static boolean[] visit;
    static int cnt=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        output = new int[n];

        permutation(0,0);

        if(m==0) cnt--;
        System.out.println(cnt);
    }

    public static void permutation(int depth, int sum){
        if(depth == n){
            if(sum==m) cnt++;
            return;
        }

        permutation(depth+1, sum+arr[depth]);
        permutation(depth+1, sum);

    }


}
