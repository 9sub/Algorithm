import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] distance;
    static int[] how_much;



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        distance = new int[n-1];
        how_much = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++)
            distance[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            how_much[i] = Integer.parseInt(st.nextToken());

        int tmp = how_much[0];
        int sum=0;
        for(int i=0;i<n-1;i++){
            if(tmp>how_much[i])
                tmp = how_much[i];
            sum+=(tmp*distance[i]);
        }

        System.out.println(sum);

    }
}
